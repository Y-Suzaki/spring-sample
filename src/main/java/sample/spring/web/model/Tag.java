package sample.spring.web.model;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class Tag {
    @Id
    public Integer id;
    public String tag;
}
