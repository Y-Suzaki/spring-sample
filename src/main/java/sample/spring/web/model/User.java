package sample.spring.web.model;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

@Entity
public class User {
    @Id
    public String id;
    public String name;
    public String address;
}
