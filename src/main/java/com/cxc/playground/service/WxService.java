package com.cxc.playground.service;

import com.cxc.playground.dto.WxCodeSessionDto;

public interface WxService {
    WxCodeSessionDto login(String code);
}
