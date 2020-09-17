package shop.itbug.ddblog.utils;


import cn.hutool.core.lang.Console;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    //静态方法：三个参数：文件的二进制，文件路径，文件名
    //通过该方法将在指定目录下添加指定文件
    public static void fileupload(byte[] file, String filePath, String fileName) throws IOException {
        //目标目录
        filePath = filePath + File.separator;
        Console.log("文件分割符号:{} ,filePath={}",File.separator,filePath);
        File targetfile = new File(filePath);
        Console.log("存放apk文件的文件夹:{}",targetfile);
        if (!targetfile.exists()) {
            Console.log("目录不存在,即将新建");
            targetfile.mkdirs();
        }

        //二进制流写入
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 获取文件扩展名
     * @param fileName  文件名
     * @return  例子 ".apk"
     */
    public static String getSuffixName(String fileName){
        Integer i = fileName.lastIndexOf(".");
        String suffixName = fileName.substring(i);
        return suffixName;
    }

    /**
     * 获取当前系统路径
     */
    public static String getUploadPath(String os_path) {
        File path = null;
        path = new File(os_path);
        if (!path.exists()) path.mkdirs();
        return os_path;
    }

    public static void main(String[] args) {
        String uploadPath = FileUtil.getUploadPath("C:/upload/images/");
    }
}