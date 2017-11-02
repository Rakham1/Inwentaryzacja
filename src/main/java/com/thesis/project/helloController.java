/*
package com.thesis.project;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    private static final String temp = "Hello, %s!";
    private final AtomicLong couter = new AtomicLong();

    @RequestMapping("/hellow")
    public hello hellow(@RequestParam(value = "name", defaultValue = "World") String name){
        return new hello(couter.incrementAndGet(), String.format(temp,name));
    }
}
*/
