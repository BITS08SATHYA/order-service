package com.ecommerce.order.controllers;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessageController {

    @Value("${app.message}")
    private String message;

    @RateLimiter(name="rateBreaker", fallbackMethod = "getMessageFallback")
    @GetMapping("/message")
    public String getMessage() {
        return message;
    }

    public String getMessageFallback(Exception e){
        return "Hello Fallback";
    }


}
