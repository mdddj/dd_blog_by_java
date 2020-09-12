package shop.itbug.ddblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.itbug.ddblog.entry.Blog;
import shop.itbug.ddblog.service.BlogService;

import javax.annotation.Resource;

@Controller
public class WriteController {

    @Resource
    private BlogService blogService;

    @GetMapping("/write")
    public String writeView(){
        return "write";
    }

    @PostMapping("/write")
    public String write(Blog blog){
        blogService.create(blog.getTitle(),blog.getContent(),blog.getLocation());
        return "view/success";
    }
}
