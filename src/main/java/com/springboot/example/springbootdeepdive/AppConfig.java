package com.springboot.example.springbootdeepdive;

import com.springboot.example.springbootdeepdive.customIntercepters.CustomInterceptorBeforeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



import javax.sql.DataSource;
import javax.sql.DataSource;
import java.util.concurrent.*;

@Configuration
public class AppConfig implements WebMvcConfigurer, AsyncConfigurer {
    @Autowired
    CustomInterceptorBeforeController customInterceptorBeforeController;
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptorBeforeController).
                addPathPatterns("/api/*").excludePathPatterns("/updateUser");
    }


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

//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:testdb");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
//        return dataSource;
//    }
//    @Bean
//    public TransactionManager userTransactionManagerWithDataSource(DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
//    @Bean
//    public PlatformTransactionManager userTransactionManagerWithJDBC(DataSource dataSource){
//        return new JdbcTransactionManager(dataSource);
//    }
////    @Bean
////    public PlatformTransactionManager userTransactionManagerWithHibernate(DataSource dataSource){
////        return new JpaTransactionManager(dataSource);
////    }
//
//
//    //use template and pass manager to it
//    public TransactionTemplate userTransactionTemplateWithTemplate(PlatformTransactionManager transactionManager){
//        return new TransactionTemplate(transactionManager);
//    }
}
