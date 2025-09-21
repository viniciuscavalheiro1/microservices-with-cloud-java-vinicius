package br.com.vinicius.controllers;

import br.com.vinicius.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/greeting")
    public Greeting Greeting(
            @RequestParam(value = "name", defaultValue = "Word")
            String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greetingTopado")
    public Greeting GreetingTopado(
            @RequestParam(value = "name", defaultValue = "Topado")
            String name) {
        return new Greeting(counter.incrementAndGet() + 1, String.format(template, name));
    }
}
