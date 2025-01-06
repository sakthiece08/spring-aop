package org.teqmonic.springaop.aspect;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class OrderAspect {

    @Before("execution(* org.teqmonic.springaop.controller.OrderController.*(..))") // any method in OrderController
    public void beforCustomerOrder() {
        log.info("@Before");
    }

    @Around("execution(* org.teqmonic.springaop.controller.OrderController.*(..))")
    public Object aroundCustomerOrder(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("@Around Start");
        Object response = joinPoint.proceed();
        log.info("@Around End");
        log.info("===================================");
        return response;
    }

    @AfterReturning("execution(* org.teqmonic.springaop.controller.OrderController.*(..))")
    public void afterReturning() {
        log.info("@AfterReturning");
    }

    @AfterThrowing("execution(* org.teqmonic.springaop.controller.OrderController.*(..))")
    public void afterThrowing() {
        log.info("@AfterThrowing");
    }

    @After("execution(* org.teqmonic.springaop.controller.OrderController.*(..))")
    public void afterFinally() {
        log.info("@After");
    }
}
