package com.sudhirt.samples.urlrewrite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/v*/users")
    public String getUri1() {
        return "this is users";
    }

    @GetMapping("/v*/users/{1}/cards")
    public String getUri2() {
        return "this is cards";
    }

    @GetMapping("/v2/users")
    public String getUri1V2() {
        return "this is users v2 implementation";
    }

}
