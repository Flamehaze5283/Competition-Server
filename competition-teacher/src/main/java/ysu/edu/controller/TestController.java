package ysu.edu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tch-test")
public class TestController {
    @GetMapping("/test")
    String Test() {
        return "success";
    }
}
