package sample.spring.web.dto;

import sample.spring.web.model.BookmarkTag;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookmarkDto {
    public Integer id;
    public String url;
    public String description;
    public List<TagDto> tags = new ArrayList<>();

    public static List<BookmarkDto> convert(List<BookmarkTag> bookmarkTags) {
        List<BookmarkDto> bookmarkDtos = new ArrayList<>();

        bookmarkTags.forEach(tag -> {
            Optional<BookmarkDto> dto = bookmarkDtos.stream().filter(x -> x.id.equals(tag.id)).findFirst();
            if(dto.isPresent()) {
                dto.get().tags.add(TagDto.convert(tag.tag_id, tag.tag));
            } else {
                BookmarkDto bookmarkDto = new BookmarkDto();
                bookmarkDto.id = tag.id;
                bookmarkDto.url = tag.url;
                bookmarkDto.description = tag.description;
                bookmarkDto.tags.add(TagDto.convert(tag.tag_id, tag.tag));
                bookmarkDtos.add(bookmarkDto);
            }
        });
        return bookmarkDtos;
    }

    @Override
    public boolean equals(Object obj) {
        BookmarkDto bookmarkDto = (BookmarkDto)obj;
        return this.id.equals(bookmarkDto.id);
    }
}
