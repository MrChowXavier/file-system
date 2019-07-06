package com.aura.filesys.service.impl;

import com.aura.filesys.dao.FileInfoDOMapper;
import com.aura.filesys.dataobject.FileInfoDO;
import com.aura.filesys.error.BusinessException;
import com.aura.filesys.error.EnumBusinessError;
import com.aura.filesys.service.FileInfoService;
import com.aura.filesys.service.model.FileInfoModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileInfoServiceImpl implements FileInfoService {
    @Autowired
    private FileInfoDOMapper fileInfoDOMapper;

    @Override
    public List<FileInfoModel> getFileInfoByUserName(String userName) {
        List<FileInfoDO> fileInfoDOS = fileInfoDOMapper.selectByUserName(userName);
        List<FileInfoModel> fileInfoModels = fileInfoDOS.stream().map(e->{
            FileInfoModel fileInfoModel = convertFromFileInfoDO(e);
            return fileInfoModel;
        }).collect(Collectors.toList());
        return fileInfoModels;
    }

    private FileInfoModel convertFromFileInfoDO(FileInfoDO fileInfoDO){
        FileInfoModel fileInfoModel = new FileInfoModel();
        BeanUtils.copyProperties(fileInfoDO,fileInfoModel);
        return fileInfoModel;
    }

    @Override
    public void addFile(FileInfoModel fileInfoModel) throws BusinessException {
        FileInfoDO fileInfoDO = convertFromFileInfoModel(fileInfoModel);
        int i = fileInfoDOMapper.insertSelective(fileInfoDO);
        if (i<0)
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR,"文件插入失败！");
    }

    FileInfoDO convertFromFileInfoModel(FileInfoModel fileInfoModel){
        FileInfoDO fileInfoDO = new FileInfoDO();
        BeanUtils.copyProperties(fileInfoModel,fileInfoDO);
        return fileInfoDO;
    }

//    @Override
//    public FileInfoModel getFileInfoByUserName(String userName) {
//        FileInfoDO fileInfoDO = fileInfoDOMapper.selectFileInfoByUserName(userName);
//        FileInfoModel fileInfoModel = new FileInfoModel();
//        BeanUtils.copyProperties(fileInfoDO,fileInfoModel);
//        return fileInfoModel;
//    }

    @Override
    public void delFile(String filePath) {
        fileInfoDOMapper.deleteByFilePath(filePath);
    }
}
