package sample.spring.web.repository;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;
import sample.spring.web.model.Bookmark;
import sample.spring.web.model.BookmarkTag;
import sample.spring.web.model.Tag;

import java.util.List;

@Dao
@ConfigAutowireable
public interface TagRepository {

    @Select
    List<Tag> selectAll();

    @Insert
    @Transactional
    int insert(Tag tag);

    @Update
    @Transactional
    int update(Tag tag);

    @Delete
    @Transactional
    int delete(Tag tag);
}
