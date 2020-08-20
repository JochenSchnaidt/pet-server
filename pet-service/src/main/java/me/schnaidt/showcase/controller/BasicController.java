package me.schnaidt.showcase.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
public class BasicController {

  private final AtomicLong counter = new AtomicLong();

  @Value("${app.label}")
  private String label;

  @GetMapping("/greeting")
  public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    log.info("call {} from {}", counter.incrementAndGet(), name);
    return "Hello " + name + " from " + label + "!";
  }
}