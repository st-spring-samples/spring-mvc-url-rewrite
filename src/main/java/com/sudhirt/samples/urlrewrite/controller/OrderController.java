package com.sudhirt.samples.urlrewrite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v*")
public class OrderController {

    @GetMapping(path = {"/orders", "/order$"})
    public String getUri1() {
        return "this is orders";
    }

    @GetMapping("/orders/{id}/items")
    public String getUri2() {
        return "this is items";
    }

}
