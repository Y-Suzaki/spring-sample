package sample.spring.web.model;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class Bookmark {
    @Id
    public String id;
    public String url;
    public String description;
}
