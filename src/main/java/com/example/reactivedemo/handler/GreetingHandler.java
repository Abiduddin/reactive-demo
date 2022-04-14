package com.example.reactivedemo.handler;

import com.example.reactivedemo.pojo.Greeting;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class GreetingHandler {
    public static int requestCount;

    public Mono<ServerResponse> hello(ServerRequest request) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(">> handler = " + Thread.currentThread());
        System.out.println(">> handler request count = " + requestCount++ + " Time: "
                + LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).getHour()
                +"-"+ LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).getMinute()
                +"-"+ LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).getSecond());
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello Spring!")));
    }
}
