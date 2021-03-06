package sample.spring.web.repository;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;
import sample.spring.web.model.User;
import java.util.List;

@Dao
@ConfigAutowireable
public interface UserRepository {

    @Select
    List<User> selectAll();

    @Select
    User selectById(Integer id);

    @Insert
    @Transactional
    int insert(User user);

    @Update
    @Transactional
    int update(User user);

    @Delete
    @Transactional
    int delete(User user);
}
