package com.springboot.example.springbootdeepdive.transactional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
         }
        @Bean
         public TransactionManager userTransactionManagerWithDataSource(DataSource dataSource){
return new DataSourceTransactionManager(dataSource);
         }
    @Bean
    public PlatformTransactionManager userTransactionManagerWithJDBC(DataSource dataSource){
        return new JdbcTransactionManager(dataSource);
    }
//    @Bean
//    public PlatformTransactionManager userTransactionManagerWithHibernate(DataSource dataSource){
//        return new JpaTransactionManager(dataSource);
//    }


//use template and pass manager to it
     public TransactionTemplate userTransactionTemplateWithTemplate(PlatformTransactionManager transactionManager){
        return new TransactionTemplate(transactionManager);
     }
}
