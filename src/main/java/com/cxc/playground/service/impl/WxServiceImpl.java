package com.cxc.playground.service.impl;

import com.cxc.playground.dto.WxCodeSessionDto;
import com.cxc.playground.service.WxService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@Service("WxServiceI")
public class WxServiceImpl implements WxService {
    @Resource
    RestTemplate restTemplate;
    @Value("${wx.account.appid}")
    String appid;
    @Value("${wx.account.secret}")
    String secret;

    String url = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    @Override
    public WxCodeSessionDto login(String code) {
        WxCodeSessionDto o = restTemplate.getForObject(String.format(url, appid, secret, code), WxCodeSessionDto.class);
        return o;
    }
}
