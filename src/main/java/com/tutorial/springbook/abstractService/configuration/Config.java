package com.tutorial.springbook.abstractService.configuration;

import com.tutorial.springbook.abstractService.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import com.tutorial.springbook.abstractService.service.UserDao;
import com.tutorial.springbook.abstractService.service.impl.UserDaoJDBC;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public UserDao userDao() {
        return new UserDaoJDBC(dataSource());
    }

    @Bean
    public UserService userService() {
        return new UserService(userDao());
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost/toby");
        dataSource.setUsername("root");
        dataSource.setPassword("<password>");

        return dataSource;
    }

}
