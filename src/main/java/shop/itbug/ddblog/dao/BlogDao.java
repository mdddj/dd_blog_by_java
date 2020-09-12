package shop.itbug.ddblog.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.itbug.ddblog.entry.Blog;

@Repository
public interface BlogDao extends JpaRepository<Blog,Long> {

    // 获取特殊位置博客
    Page<Blog> findAllByLocation(Integer location, Pageable pageable);

}
