package com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.infrastructure.adapter.out.mongo;


import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.domain.entity.UserMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataMongoUserRepository extends MongoRepository<UserMongoEntity, String> {
    boolean existsByEmail(String email);
}
