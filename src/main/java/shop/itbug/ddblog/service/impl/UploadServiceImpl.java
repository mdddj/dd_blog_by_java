package shop.itbug.ddblog.service.impl;

import cn.hutool.core.lang.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import shop.itbug.ddblog.service.UploadService;
import shop.itbug.ddblog.utils.FileUtil;

import java.io.*;
import java.util.Date;

@Service
public class UploadServiceImpl implements UploadService {

    @Value("${os_win.upload-folder}")
    private String uploadFolder;

    @Value("${os_win.url}")
    private String url; // 访问url


    @Override
    public String uploadImage(MultipartFile imageFile,String host) {
        String fileName = imageFile.getOriginalFilename();
        String suffixName = FileUtil.getSuffixName(fileName);
        String serverFileName = new Date().getTime() + suffixName;
        Console.log("保存的文件名字:{}", serverFileName);
        String filepath = FileUtil.getUploadPath(uploadFolder);
        try (BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(new File(filepath + File.separator + serverFileName)))) {
            out.write(imageFile.getBytes());
            out.flush();
            Console.log("访问路径:{}",url+serverFileName);
            return "http://"+host+url + serverFileName;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
        return "";
    }


}
