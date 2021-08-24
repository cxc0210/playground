package com.cxc.playground.utils;

import com.cxc.playground.enums.ResponseCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {
    private static final long serialVersionUID = -7470669953143017921L;

    private Integer code;

    private String message;

    private Object data;

    private Response() { }

    public Response(ResponseCode responseCode, Object data) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = data;
    }

    private void setResultCode(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    public static Response success() {
        Response response = new Response();
        response.setResultCode(ResponseCode.SUCCESS);
        return response;
    }

    public static Response success(Object data) {
        Response response = new Response();
        response.setResultCode(ResponseCode.SUCCESS);
        response.setData(data);
        return response;
    }

    public static Response fail(Integer code, String message) {
        Response response = new Response();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public static Response fail(ResponseCode responseCode) {
        Response response = new Response();
        response.setResultCode(responseCode);
        return response;
    }
}
