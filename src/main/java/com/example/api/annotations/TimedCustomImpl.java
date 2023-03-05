package com.example.api.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
@ConditionalOnExpression("${aspect.enabled:true}")
public class TimedCustomImpl {
    @Around("@annotation(com.example.api.annotations.TimedCustom)")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = point.proceed();
        long end = System.currentTimeMillis();
        long total = end - start;
        log.info("La peticion ha tardado en ejecutarse: " + total + "ms");
        return object;
    }
}

