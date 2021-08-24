package com.cxc.playground.controller;

import com.cxc.playground.annotation.CustomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CustomResponse
public class UserController {

    @PostMapping("login")
    public Map<String, Integer> login(@RequestBody Map<String, String> body) throws Exception {
        System.out.println(body.get("code"));
        Map<String, Integer> map = new HashMap();
        map.put("qingfen", 16);
        map.put("lantian", 17);
        map.put("baiyun", 18);
        return map;
    }
}
