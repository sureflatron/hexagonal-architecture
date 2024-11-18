package com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.infrastructure.config;

import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.domain.port.out.UserRepository;
import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.infrastructure.adapter.out.mongo.MongoUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public UserRepository userRepository(MongoUserRepository repository) {
        return repository;
    }
}