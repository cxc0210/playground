package com.cxc.playground.controller;

import com.cxc.playground.annotation.CustomResponse;
import com.cxc.playground.dto.WxCodeSessionDto;
import com.cxc.playground.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CustomResponse
public class UserController {
    @Resource
    private WxService wxService;

    @PostMapping("login")
    public WxCodeSessionDto login(@RequestBody Map<String, String> body) throws Exception {
        String code = body.get("code");
        WxCodeSessionDto o = wxService.login(code);
        return o;
    }
}
