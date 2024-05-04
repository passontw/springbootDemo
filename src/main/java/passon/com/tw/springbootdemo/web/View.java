package passon.com.tw.springbootdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class View {
    @GetMapping(value="/hello")
    public String view() {
        return "books";
    }
}
