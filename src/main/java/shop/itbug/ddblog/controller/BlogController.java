package shop.itbug.ddblog.controller;

import cn.hutool.core.lang.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.itbug.ddblog.entry.Blog;
import shop.itbug.ddblog.service.BlogService;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

@Controller
public class BlogController {

    @Resource
    private BlogService blogService;


    @GetMapping("/detail/{id}")
    public String detailView(@PathVariable("id") Long id, Model model){
        Blog one = blogService.findOne(id);
        if(one==null){
            return "page/404";
        }
        model.addAttribute("blog",one);
        return "detail";
    }

    @DeleteMapping("/blog/delete/{id}")
    @ResponseBody
    public boolean del(@PathVariable(name = "id")Long id){
        blogService.delete(id);
        return true;
    }

}
