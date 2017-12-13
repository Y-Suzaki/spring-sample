package sample.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.web.dto.BookmarkDto;
import sample.spring.web.repository.BookmarkRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookmark")
@CrossOrigin
public class WebBookmarkController {
    @Autowired
    private BookmarkRepository bookmarkRepository;

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
            return BookmarkDto.convert(bookmarkRepository.selectAllWithTagByTagId(tag.get()));
        } else {
            return BookmarkDto.convert(bookmarkRepository.selectAllWithTag());
        }
    }
}

