package sample.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.web.dto.TagDto;
import sample.spring.web.model.Tag;
import sample.spring.web.repository.BookmarkTagRepository;
import sample.spring.web.repository.TagRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tag")
@CrossOrigin
public class WebTagController {
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private BookmarkTagRepository bookmarkTagRepository;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<TagDto> getTags() {
        List<Tag> tags = tagRepository.selectAll();
       return  tags.stream().map(x -> TagDto.convert(x.id, x.tag)).collect(Collectors.toList());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        Tag tag = new Tag();
        tag.id = id;
        bookmarkTagRepository.deleteByTagId(id);
        tagRepository.delete(tag);
    }
}
