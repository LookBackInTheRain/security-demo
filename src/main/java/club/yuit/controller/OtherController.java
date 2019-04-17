package club.yuit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuit
 * @date 2019/4/17 9:36
 */
@RestController
@RequestMapping("/api")
public class OtherController {

    @GetMapping("/other")
    public String other(){
        return "{/api/other}";
    }

}
