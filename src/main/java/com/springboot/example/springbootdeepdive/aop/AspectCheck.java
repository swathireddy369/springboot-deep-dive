package com.springboot.example.springbootdeepdive.aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectCheck {
    @Before("execution(String com.springboot.example.springbootdeepdive.aop.AOPCheck.AOPExcute())")
    public void before(){
        System.out.println("============beforeMethod");
    }
    @Before("execution(* com.springboot.example.springbootdeepdive.aop.AOPCheck.AOPExcute())")
    public void before_wildcard1_1(){
        System.out.println("============before but any return type");
    }
    @Before("execution(* com.springboot.example.springbootdeepdive.aop.AOPCheck.*())")
    public void before_wildcard1_2(){
        System.out.println("============before but any method and any return type");
    }
    @Before("execution(* com.springboot.example.springbootdeepdive.aop.AOPCheck.AOPExcute(*))")
    public void before_wildcard1_3(){
        System.out.println("============before but any method and particular method with any argument");
    }


    @Before("execution(* com.springboot.example.springbootdeepdive.aop.AOPCheck.AOPExcute(..))")
    public void before_wildcard2_1(){
        System.out.println("============before but wildcard .. for all subpackages and classes ");
    }
    @Before("execution(* com.springboot.example.springbootdeepdive.aop..AOPExcute())")
    public void before_wildcard2_2(){
        System.out.println("============before but wildcard .. for all subpackages and classes ");
    }


    //    # within
@Before("within(com.springboot.example.springbootdeepdive.aop.AOPCheck)")
public void before_within(){
    System.out.println("============before with within AOPCheck");
}
    @Before("@within(org.springframework.web.bind.annotation.RestController)")
    public void before_within_within(){
        System.out.println("============before with within AOPCheck @within()");
    }
    //named pointcut
    @Before("namedPointcut()")
    public void before_within_within_2(){
        System.out.println("============before with within AOPCheck @within(component)");
    }

    @Pointcut("@within( org.springframework.stereotype.Component)")
    public void namedPointcut(){
        //
    }

//        # args
//    @Before("args(String,int)")
//    public void before_args(){
//        System.out.println("============before with args");
//    }
//    @Before("@args(org.springframework.web.bind.annotation.PathVariable)")
//    public void before_args_1(){
//        System.out.println("============before with @args");
//    }

//    @Annotation
    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void before_annot_1(){
        System.out.println("============GetMapping annotation");
    }
    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void before_annot_2(){
        System.out.println("============RequestMapping annotation");
    }

    //target
    @Before("target(com.springboot.example.springbootdeepdive.aop.Utility)")
    public void before_target(){
        System.out.println("============tagret");
    }

}
