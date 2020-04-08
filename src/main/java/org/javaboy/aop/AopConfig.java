package org.javaboy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
// 表示是一个切面
@Aspect
public class AopConfig {
    // 定义切点 org.javaboy.aop.service 下所有的类所有的方法 参数任意 返回值任意
    @Pointcut("execution(* org.javaboy.aop.service.*.*(..))")
    public void aop(){

    }

    // 前置通知
    @Before(value = "aop()")
    public void before(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println("before:"+name);
    }
    // 后置通知
    @After(value = "aop()")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println("after:"+name);
    }

    // 返回通知
    // 注解中 returning代表返回的结果
    @AfterReturning(value = "aop()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println("afterReturning:"+name);
        System.out.println("afterReturning:"+result);
    }
    // 异常通知
    @AfterThrowing(value = "aop()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        String name = joinPoint.getSignature().getName();
        System.out.println("afterThrowing:"+name);
        System.out.println("afterThrowing:"+e.getMessage());
    }
    // 环绕通知
    @Around("aop()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 执行扫描包里的方法之前
        System.out.println("执行之前");
        // 执行扫描包里的方法
        Object proceed = joinPoint.proceed();
        // 执行扫描包里的方法之后
        System.out.println("执行之后");
        return proceed;
    }

}
