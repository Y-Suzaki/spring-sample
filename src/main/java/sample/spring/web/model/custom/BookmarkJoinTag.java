package sample.spring.web.model.custom;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class BookmarkJoinTag {
    @Id
    @Column(name = "bookmark_id")
    public Integer id;

    @Column(name = "bookmark_url")
    public String url;

    @Column(name = "bookmark_description")
    public String description;

    @Column(name = "tag_id")
    public Integer tag_id;

    @Column(name = "tag_tag")
    public String tag;
}
