package com.example.task1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class InterceptorLog implements HandlerInterceptor {

    private long tiempoInicio;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        tiempoInicio = System.currentTimeMillis();
        System.out.println("Petición recibida: " + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, org.springframework.web.servlet.ModelAndView modelAndView) {
        System.out.println("Controlador ejecutado");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) {
        long duracion = System.currentTimeMillis() - tiempoInicio;
        System.out.println("Tiempo de ejecución: " + duracion + " ms");
    }
}
