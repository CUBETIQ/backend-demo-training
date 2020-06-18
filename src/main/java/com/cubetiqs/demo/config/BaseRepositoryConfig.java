package com.cubetiqs.demo.config;

import com.cubetiqs.demo.repository.BaseRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class, basePackages = "com.cubetiqs.demo.repository")
public class BaseRepositoryConfig {
}
