package com.aura.filesys.controller;

import com.aura.filesys.controller.viewobject.FileInfoVO;
import com.aura.filesys.error.BusinessException;
import com.aura.filesys.error.EnumBusinessError;
import com.aura.filesys.response.CommonReturnType;
import com.aura.filesys.service.FileInfoService;
import com.aura.filesys.service.model.FileInfoModel;
import com.aura.filesys.service.model.UserInfoModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Controller("file")
@RequestMapping("/file")
@CrossOrigin
public class FileUpDownController extends BaseController {
    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getFile(@RequestParam("token") String token) throws BusinessException {
        if (token==null || "".equals(token))
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST,"用户未登录！");

        //获取用户的登陆信息
        UserInfoModel userInfoModel = (UserInfoModel) redisTemplate.opsForValue().get(token);

        if (userInfoModel==null)
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST,"用户未登录！");

        List<FileInfoModel> fileInfoModels = fileInfoService.getFileInfoByUserName(userInfoModel.getUserName());
        List<FileInfoVO> fileInfoVOs = fileInfoModels.stream().map(e->{
            FileInfoVO fileInfoVO = convertFileInfoVOFromModel(e);
            return fileInfoVO;
        }).collect(Collectors.toList());
        return CommonReturnType.create(fileInfoVOs);
    }

    private FileInfoVO convertFileInfoVOFromModel(FileInfoModel fileInfoModel){
        FileInfoVO fileInfoVO = new FileInfoVO();
        BeanUtils.copyProperties(fileInfoModel,fileInfoVO);
        return fileInfoVO;
    }

    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType singleFileUpload(@RequestParam("multipartfiles") MultipartFile[] multipartfiles, @RequestParam("token") String token) throws BusinessException, IOException {
        if (token==null || "".equals(token))
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST,"用户未登录！");

        //获取用户的登陆信息
        UserInfoModel userInfoModel = (UserInfoModel) redisTemplate.opsForValue().get(token);
        if (userInfoModel==null)
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST,"用户未登录！");

        String userName = userInfoModel.getUserName();
        String path = FILE_DIR+userInfoModel.getUserName()+"/";
        File filePath = new File(path);
        boolean mkdirs = filePath.mkdirs();
//        if (mkdirs)
//            System.out.println("---path create");
//        System.out.println("---total:"+multipartfiles.length);
        for(MultipartFile item : multipartfiles){
            /* 获取文件名&文件大小 */
            String fileName = item.getOriginalFilename();
            int size = (int)item.getSize();
            /* 获取输入流 */
            BufferedInputStream bufferedInputStream = new BufferedInputStream(item.getInputStream());
            /* 获取输出流*/
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path+fileName));
            byte[] bytes = new byte[1024];
            int len;
            while ((len=bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,len);
                bufferedOutputStream.flush();
            }
            bufferedOutputStream.close();
            bufferedInputStream.close();

            /* 写入Mysql*/
            fileInfoService.addFile(new FileInfoModel(userName,fileName,filePath.toString()+"/"+fileName,size));
        }
        return CommonReturnType.create(new String("恭喜您，文件上传成功！"));
    }

    @RequestMapping(value = "/download", method = {RequestMethod.GET})
    public void download(@RequestParam("url") String url, HttpServletResponse response){
        File file=new File(url);
        if(file.exists()){
            //首先设置响应的内容格式是force-download，那么你一旦点击下载按钮就会自动下载文件了
            response.setContentType("application/force-download");
            //通过设置头信息给文件命名，也即是，在前端，文件流被接受完还原成原文件的时候会以你传递的文件名来命名
            response.addHeader("Content-Disposition","attachment; filename="+file.getName());
            //进行读写操作
            byte[] bytes = new byte[1024];
            BufferedInputStream bufferedInputStream = null;
            try{
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                OutputStream os = response.getOutputStream();
                int len;
                while ((len=bufferedInputStream.read(bytes)) != -1){
                    os.write(bytes,0,len);
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    if(bufferedInputStream != null){
                        bufferedInputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType delete(@RequestParam("token") String token, @RequestParam("filePath") String filePath) throws BusinessException {
        if (token==null || "".equals(token))
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST,"用户未登录！");

        fileInfoService.delFile(filePath);
        return CommonReturnType.create(new String("文件删除成功！"));
    }
}
