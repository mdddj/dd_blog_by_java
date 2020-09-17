package shop.itbug.ddblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.itbug.ddblog.entry.Blog;
import shop.itbug.ddblog.service.BlogService;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class WriteController {

    @Resource
    private BlogService blogService;

    @GetMapping("/write")
    public String writeView(@RequestParam(name = "update",required = false) Long updateId, Model model) {
        if(updateId!=null){
            Blog blog = blogService.findOne(updateId);
            if(blog!=null) {
                model.addAttribute("updateBlog",blog);
                model.addAttribute("hasBlog",true);
            }
        }
        return "write";
    }

    @PostMapping("/write")
    public String write(Blog blog) {
        if(blog.getId()!=null){
            blog.setCreateTime(new Date());
            blogService.update(blog);
        }else{
            blogService.create(blog.getTitle(), blog.getContent(), blog.getLocation());
        }

        return "view/success";
    }
}
