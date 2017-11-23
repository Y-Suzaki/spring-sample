package sample.spring.web.repository;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import sample.spring.web.model.User;
import java.util.List;

@Dao
@ConfigAutowireable
public interface UserRepository {

    @Select
    List<User> selectAll();

    @Select
    User selectById(Integer id);
}
