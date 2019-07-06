package com.aura.filesys.service;

import com.aura.filesys.error.BusinessException;
import com.aura.filesys.service.model.UserInfoModel;

public interface UserInfoService {
    void userRegister(UserInfoModel userInfoModel) throws BusinessException;
    UserInfoModel validateLogin(String userName, String userPswd) throws BusinessException;
}
