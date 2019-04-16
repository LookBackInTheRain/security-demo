package clbu.yuit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuit
 * @date 2019/4/15 11:18
 */
@RestController
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
