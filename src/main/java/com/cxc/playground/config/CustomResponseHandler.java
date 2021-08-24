package com.cxc.playground.config;

import com.cxc.playground.annotation.CustomResponse;
import com.cxc.playground.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class CustomResponseHandler implements ResponseBodyAdvice<Object> {
    private static final String CUSTOM_RESPONSE_ANN = "CUSTOM-RESPONSE-ANN";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes sra =(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        CustomResponse customResponse = (CustomResponse)request.getAttribute(CUSTOM_RESPONSE_ANN);
        log.info(customResponse.toString());
        return customResponse==null?false:true;
    }

    @Override
    public Object beforeBodyWrite(Object result, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(result instanceof Response){
            return (Response) result;
        }
        return Response.success(result);
    }
}
