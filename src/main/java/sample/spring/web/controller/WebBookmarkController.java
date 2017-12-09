package sample.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import sample.spring.web.model.Bookmark;
import sample.spring.web.repository.BookmarkRepository;

import java.util.List;

@RestController
@RequestMapping("/bookmark")
@CrossOrigin
public class WebBookmarkController {
    @Autowired
    private BookmarkRepository bookmarkRepository;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Bookmark> getBookmarks() {
        return bookmarkRepository.selectAll();
    }
}
