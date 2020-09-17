package shop.itbug.ddblog.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.itbug.ddblog.entry.Blog;
import shop.itbug.ddblog.service.BlogService;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource
    private BlogService blogService;

    @RequestMapping(value = {"/"})
    public String indexView(Model model, @Param("page")Integer page){
        Page<Blog> blogs = blogService.find(page == null ? 0 : page);

        // 获取置顶的博客(大)
        Page<Blog> top = blogService.findTop(1, 0, 2);
        model.addAttribute("top",top.getContent());

        //卡片置顶的博客


        model.addAttribute("data",blogs);
        model.addAttribute("list",blogs.getContent());
        return "index";
    }

}
