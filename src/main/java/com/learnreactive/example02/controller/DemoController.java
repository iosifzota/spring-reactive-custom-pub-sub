package com.learnreactive.example02.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnreactive.example02.publisher.CustomPub;
import com.learnreactive.example02.subscriber.CustomSubcriber;

import reactor.core.publisher.Flux;

@RestController
public class DemoController {
   
    @GetMapping("/demo")
    public void demo() {
        CustomPub pub = new CustomPub(List.of(1,2,3,4,5,6));
        pub.subscribe(new CustomSubcriber());
    }
}
