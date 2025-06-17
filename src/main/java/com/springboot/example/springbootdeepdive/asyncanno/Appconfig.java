package com.springboot.example.springbootdeepdive.asyncanno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Queue;
import java.util.concurrent.*;

@Configuration
public class Appconfig implements AsyncConfigurer {
//    @Bean
//    public Executor getTaskExecutor(){
//        System.out.println("getTaskExecutor");
//        //springboot threadexecutor
//        ThreadPoolTaskExecutor excutor=new ThreadPoolTaskExecutor();
//        excutor.setCorePoolSize(2);
//        excutor.setMaxPoolSize(4);
//        excutor.setQueueCapacity(3);
//        excutor.setKeepAliveSeconds(60);
//        excutor.initialize();
//        return excutor;
//    }
//    @Bean
//    public Executor getThreadPoolExecutor(){
//        System.out.println("ThreadpoolExecutor");
//        ThreadPoolExecutor executor;
//        executor = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return null;
//            }
//        }, new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//            }
//        });
//                return executor;
//    }

@Override
    public Executor getAsyncExecutor(){
    System.out.println("my default");
        ThreadPoolExecutor executor;
        executor=new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        });
        System.out.println("MyDefaultExecutor");//
        return executor;
    }

}
