package tom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController
{
    @GetMapping("/faculty/setgrade")
    public String test()
    {
        return "/faculty/setgrade";
    }

    @GetMapping("/student/query")
    public String test1()
    {
        return "/student/grade-query";
    }
}