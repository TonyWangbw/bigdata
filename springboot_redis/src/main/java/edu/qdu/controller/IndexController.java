package edu.qdu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {



    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/")
    public String homePage(){
        redisTemplate.opsForValue().set("name","sunyang");
        return "OK";
    }
}
