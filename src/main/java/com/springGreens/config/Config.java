package com.springGreens.config;

import com.springGreens.dao.UserDao;
import com.springGreens.util.connection.ConnectionMaker;
import com.springGreens.util.connection.impl.NConnectionMaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    UserDao userDao() {return new UserDao(connectionMaker());}

    @Bean
    ConnectionMaker connectionMaker() {
        return new NConnectionMaker();
    }
}
