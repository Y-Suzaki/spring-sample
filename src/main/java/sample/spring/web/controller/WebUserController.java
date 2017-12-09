package sample.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sample.spring.web.model.User;
import sample.spring.web.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class WebUserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="", method=RequestMethod.GET)
    public List<String> getUserIds() {
        List<User> users = userRepository.selectAll();
        List<String> ids = users.stream().map(x -> x.id).collect(Collectors.toList());
        return ids;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable String id) {
        User user = userRepository.selectById(Integer.parseInt(id));
        return user;
    }
}
