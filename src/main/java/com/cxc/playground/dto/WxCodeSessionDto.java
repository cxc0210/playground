package com.cxc.playground.dto;

import lombok.Data;

@Data
public class WxCodeSessionDto {
    private String openid;
    private String session_key;
    private String unionid;
    private Integer errcode;
    private String errmsg;
}
