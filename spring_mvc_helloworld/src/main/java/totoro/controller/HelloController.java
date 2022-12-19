package totoro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Totoro
 * @create 24 16:54
 */

@Controller
public class HelloController {
    @RequestMapping("/")
    public String protal() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
}
