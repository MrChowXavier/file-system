package com.aura.filesys.service;

import com.aura.filesys.error.BusinessException;
import com.aura.filesys.service.model.FileInfoModel;

import java.util.List;

public interface FileInfoService {
    List<FileInfoModel> getFileInfoByUserName(String userName);
    void addFile(FileInfoModel fileInfoModel) throws BusinessException;
    void delFile(String filePath);
}
