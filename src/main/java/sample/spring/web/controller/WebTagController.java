package sample.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sample.spring.web.dto.BookmarkDto;
import sample.spring.web.dto.TagDto;
import sample.spring.web.model.BookmarkTag;
import sample.spring.web.model.Tag;
import sample.spring.web.repository.BookmarkRepository;
import sample.spring.web.repository.TagRepository;

import javax.swing.text.html.HTML;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tag")
@CrossOrigin
public class WebTagController {
    @Autowired
    private TagRepository tagRepository;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<TagDto> getTags() {
        List<Tag> tags = tagRepository.selectAll();
       return  tags.stream().map(x -> TagDto.convert(x.id, x.tag)).collect(Collectors.toList());
    }
}
