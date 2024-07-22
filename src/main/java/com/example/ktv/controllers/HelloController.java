package com.example.ktv.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/boy")
    public ResponseEntity<String> hello(){
        return  ResponseEntity.ok("Hello boy");
    }
    @GetMapping("/boy2")
    public ResponseEntity<String> hello2(){
        return  ResponseEntity.ok("Hello boy2");
    }
}
