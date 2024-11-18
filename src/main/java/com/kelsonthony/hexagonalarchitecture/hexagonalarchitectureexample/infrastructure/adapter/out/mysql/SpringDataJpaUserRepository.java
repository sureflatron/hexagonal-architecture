package com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.infrastructure.adapter.out.mysql;

import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.domain.entity.UserMysqlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaUserRepository extends JpaRepository<UserMysqlEntity, Long> {

    boolean existsByEmail(String email);

}