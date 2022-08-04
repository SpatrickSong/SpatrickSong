package com.beyondsoft.sprintbootdemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {

    /**
     * 由于不能直接访问upload.html，在这里作为页面跳转
     * @return
     */
    @RequestMapping("/index")
    public String toUpload(){
        return "upload";
    }

    @RequestMapping("/indexs")
    public String toUploads(){
        return "uploads";
    }

    /**
     * 触发动作对应upload.html里面的form表单中的action
     * upload.html里面的action="/upload"
     * 对应于UploadController中的uploadFile()函数
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(MultipartFile file, HttpServletRequest request){ //这里的参数名必须和表单上的名称相同
        //创建文件在服务器端的存放路径
        try {
            String dir = request.getServletContext().getRealPath("/uploadInfo");
            File fileDir = new File(dir);

            if(!fileDir.exists())
                fileDir.mkdirs();
            //生成文件在服务器端存放的名字
            String fileSuffix = file.getOriginalFilename()
                    .substring(file.getOriginalFilename().lastIndexOf("."));
            String fileName = UUID.randomUUID().toString()+fileSuffix;
            System.out.println("开始上传文件 " + fileName);
            File files = new File(fileDir+"/"+fileName);
            //上传文件
            file.transferTo(files);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }


    @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFiles(MultipartFile[] file, HttpServletRequest request){
        //创建文件在服务器端的存放路径
        try {
            String dir = request.getServletContext().getRealPath("/uploadInfo");
            File fileDir = new File(dir);

            if(!fileDir.exists())
                fileDir.mkdirs();
            //生成文件在服务器端存放的名字
            for (int i = 0; i <file.length ; i++) {
                String fileSuffix = file[i].getOriginalFilename()
                        .substring(file[i].getOriginalFilename().lastIndexOf("."));
                String fileName = UUID.randomUUID().toString()+fileSuffix;
                System.out.println("开始上传文件 " + fileName);
                File files = new File(fileDir+"/"+fileName);
                //上传文件
                file[i].transferTo(files);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }
}
