package shop.itbug.ddblog.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import shop.itbug.ddblog.entry.Blog;

@Service
public interface BlogService {

    Blog create(String title,String content,Integer location);

    Page<Blog> find(int page);

    Blog findOne(Long id);

    /**
     * 获取置顶的博客
     * @return
     */
    Page<Blog>  findTop(Integer location,int page,int size);
}
