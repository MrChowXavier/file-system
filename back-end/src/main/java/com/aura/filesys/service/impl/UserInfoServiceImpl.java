package com.aura.filesys.service.impl;

import com.aura.filesys.dao.UserInfoDOMapper;
import com.aura.filesys.dao.UserPswdDOMapper;
import com.aura.filesys.dataobject.UserInfoDO;
import com.aura.filesys.dataobject.UserPswdDO;
import com.aura.filesys.error.BusinessException;
import com.aura.filesys.error.EnumBusinessError;
import com.aura.filesys.service.UserInfoService;
import com.aura.filesys.service.model.UserInfoModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    /*
    用户注册模块
     */
    @Autowired
    private UserInfoDOMapper userInfoDOMapper;

    @Override
    @Transactional  /* 事物处理 */
    public void userRegister(UserInfoModel userInfoModel) throws BusinessException{
        /* 根据模型转换用户对象 */
        UserInfoDO userInfoDO = convertUserInfoDOFromModel(userInfoModel);
        try {
            userInfoDOMapper.insertSelective(userInfoDO);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR,"用户名已存在！");
        }

        /* 根据模型转换密码对象 */
        UserPswdDO userPswdDO = convertUserPswdDOFromModel(userInfoModel);
        userPswdDOMapper.insertSelective(userPswdDO);
    }

    private UserInfoDO convertUserInfoDOFromModel(UserInfoModel userInfoModel){
        if (userInfoModel==null)
            return null;

        UserInfoDO userInfoDO = new UserInfoDO();
        BeanUtils.copyProperties(userInfoModel,userInfoDO);
        return userInfoDO;
    }

    private UserPswdDO convertUserPswdDOFromModel(UserInfoModel userInfoModel){
        if (userInfoModel==null)
            return null;

        UserPswdDO userPswdDO = new UserPswdDO();
        BeanUtils.copyProperties(userInfoModel,userPswdDO);
        return userPswdDO;
    }

    /*
    用户登陆模块
     */
    @Autowired
    private UserPswdDOMapper userPswdDOMapper;

    @Override
    public UserInfoModel validateLogin(String userName, String userPswd) throws BusinessException {
        UserInfoModel userInfoModel = getUserInfoModelByName(userName);
        if (!userInfoModel.getUserPswd().equals(userPswd))
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR, "用户名或密码错误！");
        return userInfoModel;
    }

    /* 用户名获取用户对象 */
    private UserInfoModel getUserInfoModelByName(String userName) throws BusinessException {
        UserInfoDO userInfoDO = userInfoDOMapper.selectByPrimaryKey(userName);
        if(userInfoDO == null)
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR,"用户不存在！");
        UserPswdDO userPswdDO = userPswdDOMapper.selectByPrimaryKey(userName);
        if (userPswdDO==null)
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR,"密码不存在！");
        return convertModelFromDataObject(userInfoDO, userPswdDO);
    }
    /* 组装Model对象 */
    private UserInfoModel convertModelFromDataObject(UserInfoDO userInfoDO, UserPswdDO userPswdDO){
        UserInfoModel userModel = new UserInfoModel();
        BeanUtils.copyProperties(userInfoDO,userModel);
        userModel.setUserPswd(userPswdDO.getUserPswd());
        return userModel;
    }
}
