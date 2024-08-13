package com.example.redis_example.controller;

import com.example.redis_example.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Map;

@RestController
@RequestMapping("/api/redis")
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/setValue")
    public void setValue(@RequestBody Map<String, Object> param) {
        if(param.get("duration") == null) {
            redisService.setValues(
                    param.get("key").toString(),
                    param.get("value").toString()
            );
        }else {
            redisService.setValues(
                param.get("key").toString(),
                param.get("value").toString(),
                (Duration) param.get("duration")
            );
        }
    }

    @GetMapping("/getValue")
    public String getValue(@RequestBody Map<String, Object> param) {
        return redisService.getValue(param.get("key").toString());
    }
}
