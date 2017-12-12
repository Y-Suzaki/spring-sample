package sample.spring.web.dto;

public class TagDto {
    public Integer id;
    public  String tag;

    public static TagDto convert(Integer id, String tag) {
        TagDto tagDto = new TagDto();
        tagDto.id = id;
        tagDto.tag = tag;
        return tagDto;
    }
}
