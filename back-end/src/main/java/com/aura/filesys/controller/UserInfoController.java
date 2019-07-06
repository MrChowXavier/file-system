package com.aura.filesys.controller;

import com.alibaba.fastjson.JSON;
import com.aura.filesys.error.BusinessException;
import com.aura.filesys.response.CommonReturnType;
import com.aura.filesys.service.UserInfoService;
import com.aura.filesys.service.model.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller("user")
@RequestMapping("/user")
@CrossOrigin
public class UserInfoController extends BaseController{
    /*
    用户注册模块
     */
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/register", method = {RequestMethod.POST},produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType userRegister(HttpServletRequest httpServletRequest) throws BusinessException, IOException {
        BufferedReader reader = httpServletRequest.getReader();
        UserInfoModel userInfoModel = JSON.parseObject(reader.readLine(),UserInfoModel.class);
        reader.close();
        userInfoService.userRegister(userInfoModel);
        return CommonReturnType.create(new String("恭喜您，用户注册成功！"));
    }

    /*
    用户登陆模块
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType userLogin(@RequestParam(name="userName") String userName, @RequestParam(name="userPswd") String userPswd) throws BusinessException {
        UserInfoModel userInfoModel = userInfoService.validateLogin(userName, userPswd);
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        /* 存入redis */
        redisTemplate.opsForValue().set(uuid,userInfoModel);
        redisTemplate.expire(uuid,1, TimeUnit.HOURS);
        return CommonReturnType.create(uuid);
    }
}
