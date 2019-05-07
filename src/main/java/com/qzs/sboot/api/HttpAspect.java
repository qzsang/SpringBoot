package com.qzs.sboot.api;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


//@Aspect
@Component
public class HttpAspect {
    //使用org.slf4j.Logger,这是Spring实现日志的方法

    /**
     * 定义AOP扫描路径
     * 第一个注解只扫描aopTest方法
     */
    //@Pointcut("execution(public * com.aston.reader.controller.StudentController.aopTest())")
    @Pointcut("execution(public * com.qzs.sboot.api.CityController.login(..))")
    public void log(){}

    /**
     * 记录HTTP请求开始时的日志
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //URL
        System.out.println("url={}"+":" + request.getRequestURI());
        //method
        System.out.println("method={}"+":" + request.getMethod());
        //ip
        System.out.println("ip={}"+":" +request.getRemoteAddr());
        //类方法
        System.out.println("class={} and method name = {}"+":" +joinPoint.getSignature().getDeclaringTypeName()+" " +joinPoint.getSignature().getName());
        //参数
        System.out.println("参数={}"+":" +joinPoint.getArgs());
        System.out.println();
    }

    /**
     * 记录HTTP请求结束时的日志
     */
    @After("log()")
    public void doAfter(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("url = {} end of execution"+":" +request.getRequestURL());
    }

    /**
     * 获取返回内容
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturn(Object object){
        try {
            System.out.println("response={}"+":" +object.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }

    }



    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("log()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("方法环绕start.....");
        try {

            Object o =  pjp.proceed(new Object[]{pjp.getArgs()[0],"slh","12345678"});
            System.out.println("方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}