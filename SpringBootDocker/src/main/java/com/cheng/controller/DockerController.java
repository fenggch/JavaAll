package com.cheng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-09-01
 */
@RestController
@RequestMapping
public class DockerController {


    @GetMapping
    public Object sayHello(){
        return "Hello Docker";
    }
}
