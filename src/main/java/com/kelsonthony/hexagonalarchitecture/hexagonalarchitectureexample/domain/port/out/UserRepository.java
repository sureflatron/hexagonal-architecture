package com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.domain.port.out;

import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.application.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {
    Page<UserDto> findAll(Pageable pageable);

    UserDto findById(Object id);

    UserDto save(UserDto user);

    boolean existsByEmail(String email);

    UserDto update(UserDto user);

     void delete(Object id);
}
