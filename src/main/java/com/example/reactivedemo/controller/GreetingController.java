package com.example.reactivedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public Mono<String> getGreeting()
    {
        return Mono.just("Hello hello");
    }
}
