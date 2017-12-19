package sample.spring.web.model;

import org.seasar.doma.*;
import sample.spring.web.dto.BookmarkDto;

@Entity
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "url")
    public String url;

    @Column(name = "description")
    public String description;

    public static Bookmark convert(BookmarkDto bookmarkDto) {
        Bookmark bookmark = new Bookmark();
        bookmark.id = bookmarkDto.id;
        bookmark.url = bookmarkDto.url;
        bookmark.description = bookmarkDto.description;
        return bookmark;
    }
}