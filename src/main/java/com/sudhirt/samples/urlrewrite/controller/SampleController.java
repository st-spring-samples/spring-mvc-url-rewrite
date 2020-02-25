package com.sudhirt.samples.urlrewrite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class SampleController {

    @GetMapping(path = {"/uri1", "/another-uri1"})
    public String getUri1() {
        return "this is uri1";
    }

    @GetMapping("/uri2")
    public String getUri2() {
        return "this is uri2";
    }

    @GetMapping("/uri3")
    public String getUri3() {
        return "this is uri3";
    }
}
