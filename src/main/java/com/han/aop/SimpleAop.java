package com.han.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SimpleAop {

    /*获取log4j2对象*/
    private Logger logger= LoggerFactory.getLogger(this.getClass());


    /*定义一个切入点*/
    @Pointcut("execution(* com.han.service.*.*(..))")
    public void excudeService(){};

    @Before("excudeService()")
    public void workBefore(){
        logger.info("在执行操作前进行的操作");
    }
}
