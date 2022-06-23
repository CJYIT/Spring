package com.cjy.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect //标注当前MyAspect是一个切面类
public class MyAspect {
    //    @Before("execution(* com.cjy.anno.*.*(..))")
    public void before() {
        System.out.println("前置增强......");
    }

//    @After("execution(* com.cjy.anno.*.*(..))")
    @AfterThrowing("pointcut()")
    public void afterReturning() {
        System.out.println("后置增强......");
    }

    //Proceeding JoinPoint:  正在执行的连接点===切点
//    @Around("execution(* com.cjy.anno.*.*(..))")
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强......");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强......");
        return proceed;
    }
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("异常抛出增强..........");
    }

    //    @After("execution(* com.cjy.anno.*.*(..))")
    @After("MyAspect.pointcut()")
    public void after() {
        System.out.println("最终增强..........");
    }//不管抛不抛异常最终方法都会被执行

    //定义切点表达式
    @Pointcut("execution(* com.cjy.anno.*.*(..))")
    public void pointcut() {
    }

}
