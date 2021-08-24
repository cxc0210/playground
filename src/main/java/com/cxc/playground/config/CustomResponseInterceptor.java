package com.cxc.playground.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.method.HandlerMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import com.cxc.playground.annotation.CustomResponse;

@Slf4j
public class CustomResponseInterceptor implements HandlerInterceptor {
    private static final String CUSTOM_RESPONSE_ANN = "CUSTOM-RESPONSE-ANN";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            if (clazz.isAnnotationPresent(CustomResponse.class)) {
                request.setAttribute(CUSTOM_RESPONSE_ANN, clazz.getAnnotation(CustomResponse.class));
            } else if (method.isAnnotationPresent(CustomResponse.class)) {
                request.setAttribute(CUSTOM_RESPONSE_ANN, method.getAnnotation(CustomResponse.class));
            }
        }
        return true;
    }
}
