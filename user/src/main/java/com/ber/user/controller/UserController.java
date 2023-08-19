package com.ber.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 鳄鱼儿
 * @Description TODO
 * @date 2023/8/19 14:10
 * @Version 1.0
 */

@RestController
public class UserController {

    @GetMapping("test")
    public String test(){
        return "Ber user module";
    }
}
