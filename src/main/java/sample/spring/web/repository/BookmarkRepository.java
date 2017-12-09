package sample.spring.web.repository;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;
import sample.spring.web.model.Bookmark;

import java.util.List;

@Dao
@ConfigAutowireable
public interface BookmarkRepository {

    @Select
    List<Bookmark> selectAll();

    @Select
    Bookmark selectById(Integer id);

    @Insert
    @Transactional
    int insert(Bookmark bookmark);

    @Update
    @Transactional
    int update(Bookmark bookmark);

    @Delete
    @Transactional
    int delete(Bookmark bookmark);
}