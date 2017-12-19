package sample.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sample.spring.web.dto.BookmarkDto;
import sample.spring.web.model.Bookmark;
import sample.spring.web.model.BookmarkTag;
import sample.spring.web.model.Tag;
import sample.spring.web.repository.BookmarkRepository;
import sample.spring.web.repository.BookmarkTagRepository;
import sample.spring.web.repository.TagRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookmark")
@CrossOrigin
public class WebBookmarkController {
    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private BookmarkTagRepository bookmarkTagRepository;

    /**
     * Bookmarkのリストを取得します。
     * <p>
     *     各Bookmarkに関連するTag情報のリストも付与されます。
     * </p>
     *
     * @param tag URLのtagパラメータが設定されます。
     * @return {@link BookmarkDto}
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<BookmarkDto> getBookmarks(@RequestParam(name = "tag", required = false) Optional<Integer> tag) {
        if(tag.isPresent()) {
            List<Integer> ids = bookmarkRepository.selectIdsByTagId(tag.get());
            return BookmarkDto.convert(bookmarkRepository.selectAllWithTagByIds(ids));
        } else {
            return BookmarkDto.convert(bookmarkRepository.selectAllWithTag());
        }
    }

    @Transactional
    @RequestMapping(value = "", method = RequestMethod.POST)
    public BookmarkDto create(@RequestBody BookmarkDto bookmarkDto) {
        Bookmark bookmark = Bookmark.convert(bookmarkDto);
        bookmarkRepository.insert(bookmark);

        List<Tag> tags = Tag.convert(bookmarkDto.tags);
        tags.forEach(x -> {
            tagRepository.insert(x);
            BookmarkTag bookmarkTag = new BookmarkTag();
            bookmarkTag.bookmarkId = bookmark.id;
            bookmarkTag.tagId = x.id;
            bookmarkTagRepository.insert(bookmarkTag);
        });

        return new BookmarkDto();
    }
}

