package shop.itbug.ddblog.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import shop.itbug.ddblog.dao.BlogDao;
import shop.itbug.ddblog.entry.Blog;
import shop.itbug.ddblog.service.BlogService;
import shop.itbug.ddblog.utils.HtmlUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao;

    @Value("${spring.security.user.name}")
    private String author;

    @Override
    public Blog create(String title, String content,Integer location) {

        // 获得简要信息
        String s = HtmlUtil.StripHT(content);
        String shortContent;
        if(s.length()<=150){
            shortContent = s;
        }else{
            shortContent = s.substring(0,150);
        }
        Blog blog = new Blog();
        blog.setAuthor(author);
        blog.setContent(content);
        blog.setCreateTime(new Date());
        blog.setSortContent(shortContent);
        blog.setLocation(location);
        blog.setTitle(title);
        return blogDao.save(blog);
    }

    @Override
    public Page<Blog> find(int page) {
        PageRequest pageRequest = PageRequest.of(page,4, Sort.Direction.DESC,"createTime");
        return blogDao.findAll(pageRequest);
    }

    @Override
    public Blog findOne(Long id) {
        Optional<Blog> blog = blogDao.findById(id);
        return blog.orElse(null);
    }

    /**
     * 获取置顶的博客
     *
     * @param location  博客特殊位置
     * @param page  页数
     * @param size 每页数量
     * @return 完整数据
     */
    @Override
    public Page<Blog> findTop(Integer location, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page,size, Sort.Direction.DESC,"createTime");
       return blogDao.findAllByLocation(location, pageRequest);
    }

    @Override
    public void update(Blog blog) {
        blogDao.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogDao.deleteById(id);
    }


}
