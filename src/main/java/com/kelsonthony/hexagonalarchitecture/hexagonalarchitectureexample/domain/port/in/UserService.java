package com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.domain.port.in;

import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.application.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDto getUserById(Object id);

    UserDto createUser(UserDto user);

    Page<UserDto> findAll(Pageable pageable);

    UserDto updateUser(Object id, UserDto user);

    Boolean deleteUser(Object id);

}
