package sample.spring.web.model;

import org.seasar.doma.*;

@Entity
@Table(name = "bookmark_tag")
public class BookmarkTag {
    @Id
    @Column(name = "bookmark_id")
    public Integer bookmarkId;

    @Id
    @Column(name = "tag_id")
    public Integer tagId;
}