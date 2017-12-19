package sample.spring.web.model;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import sample.spring.web.dto.TagDto;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String tag;

    public static List<Tag> convert(List<TagDto> tagDtos) {
        List<Tag> tags = new ArrayList<>();
        tagDtos.forEach(x -> {
            Tag tag = new Tag();
            tag.id = x.id;
            tag.tag = x.tag;
            tags.add(tag);
        });
        return tags;
    }
}
