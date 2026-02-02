package com.traineeMgmt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.traineeMgmt.dao.TraineeDao;
import com.traineeMgmt.dao.jdbc.TraineeJdbcDao;
import com.traineeMgmt.dao.jpa.TraineeJpaDAO;

@Configuration
public class DaoConfig {

    @Value("${trainee.dao.type}")
    private String daoType;

    @Bean
    @ConditionalOnProperty(name = "trainee.dao.type", havingValue = "jdbc")
    public TraineeDao jdbcDao(TraineeJdbcDao dao) {
        return dao;
    }

    @Bean
    @ConditionalOnProperty(name = "trainee.dao.type", havingValue = "jpa")
    public TraineeDao jpaDao(TraineeJpaDAO dao) {
        return dao;
    }
}


