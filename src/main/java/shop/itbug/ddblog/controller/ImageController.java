package shop.itbug.ddblog.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import shop.itbug.ddblog.service.UploadService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ImageController {

    @Resource
    private UploadService uploadService;

    @PostMapping("/ckeditor/upload/image")
    public Map<String, String> uploadCkEditorImage(MultipartFile upload, HttpServletRequest request) {
        if (upload!=null && !upload.isEmpty()) {
            String s = uploadService.uploadImage(upload,request.getHeader("Host"));
            Map<String, String> result = new HashMap<String, String>();
            result.put("uploaded", true + "");
            result.put("url", s);
            return result;
        }
        return null;
    }
}
