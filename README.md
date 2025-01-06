# Spring-AOP

## Around Advice:
```
    @Around("execution(* org.teqmonic.springaop.controller.OrderController.*(..))")
    public Object aroundCustomerOrder(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("@Around Start");
        Object response = joinPoint.proceed();
        log.info("@Around End");
        log.info("===================================");
        return response;
    }
```

### Order of execution for happy path:
```
@Around Start -> @Before -> @AfterReturning -> @After -> @Around End
```

### Order of execution for negative path:
```
@Around Start -> @Before -> @AfterThrowing -> @After
```
