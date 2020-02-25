package com.sudhirt.samples.urlrewrite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class SampleControllerV2 {

    @GetMapping(path = {"/uri1", "/another-uri1"})
    public String getUri1() {
        return "this is uri1";
    }

}
