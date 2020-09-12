package shop.itbug.ddblog.entry;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;

@Entity
@Getter
@Setter
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String title;

    @Lob
    private String content;

    @Lob
    private String sortContent;

    private Date createTime;

    private String author;

    // 位置 1 -- 置顶  2 -- 副置顶 3 -- 普通
    private Integer location;
}
