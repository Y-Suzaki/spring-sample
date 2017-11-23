package sample.spring.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 直接コンテンツを返すような場合に付けるアノテーション
 * Viewを返すような場合は@Controllerをつける。
 */
@RestController
@RequestMapping("/")
public class WebRootController {

    @RequestMapping(method= RequestMethod.GET)
    String root() {
        return "Hello spring boot.";
    }
}
