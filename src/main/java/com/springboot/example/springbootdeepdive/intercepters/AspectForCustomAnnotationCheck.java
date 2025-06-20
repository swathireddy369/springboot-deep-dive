package com.springboot.example.springbootdeepdive.intercepters;

import com.springboot.example.springbootdeepdive.annotations.MyCustomAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectForCustomAnnotationCheck {

    //pointcut
    @Around("@annotation(com.springboot.example.springbootdeepdive.annotations.MyCustomAnnotation)")
    public Object annotationCheck(ProceedingJoinPoint jointPoint,MyCustomAnnotation myCustomAnnotation)throws Throwable{

        System.out.println("--------------------before proceed");
         Object result=jointPoint.proceed();
        System.out.println("------------------after proceed"+result);
        return result;
    }
}
