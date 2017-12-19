package sample.spring.web.repository;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;
import sample.spring.web.model.BookmarkTag;
import sample.spring.web.model.Tag;

import java.util.List;

@Dao
@ConfigAutowireable
public interface BookmarkTagRepository {

    @Insert
    @Transactional
    int insert(BookmarkTag bookmarkTag);

    @Update
    @Transactional
    int update(BookmarkTag bookmarkTag);

    @Delete
    @Transactional
    int delete(BookmarkTag bookmarkTag);

    @Delete(sqlFile = true)
    @Transactional
    int deleteByBookmarkId(Integer bookmarkId);

    @Delete(sqlFile = true)
    @Transactional
    int deleteByTagId(Integer tagId);
}
