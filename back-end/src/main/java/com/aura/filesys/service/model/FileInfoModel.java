package com.aura.filesys.service.model;

public class FileInfoModel {
    private String userName;
    private String fileName;
    private String filePath;
    private Integer fileSize;

    public FileInfoModel() {
    }

    public FileInfoModel(String userName, String fileName, String filePath, Integer fileSize) {
        this.userName = userName;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }
}
