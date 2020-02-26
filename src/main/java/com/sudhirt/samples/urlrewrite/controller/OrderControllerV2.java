package com.sudhirt.samples.urlrewrite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class OrderControllerV2 {

    @GetMapping(path = {"/orders", "/order$"})
    public String getUri1() {
        return "this is orders v2 implementation";
    }

}
