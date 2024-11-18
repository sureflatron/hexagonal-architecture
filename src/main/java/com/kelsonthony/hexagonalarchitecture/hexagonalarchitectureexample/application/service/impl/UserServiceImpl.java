package com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.application.service.impl;

import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.infrastructure.common.exception.EmailAlreadyExistsException;
import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.infrastructure.common.exception.UserNotFoundException;
import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.domain.port.in.UserService;
import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.domain.port.out.UserRepository;
import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.application.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto getUserById(Object id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public UserDto createUser(UserDto user) {
        // Verifica se o email já existe
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException(user.getEmail());
        }

        return userRepository.save(user);
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {

        //  Page<UserDto> users = userRepository.findAll(pageable);
        //  return users.map(user -> modelMapper.map(user, UserDto.class));

        return userRepository.findAll(pageable);
    }

    @Override
    public UserDto updateUser(Object id, UserDto user) {
        // Verifica se existe
        if (userRepository.findById(id) == null) {
            throw new UserNotFoundException(id.toString());
        }
        user.setId(id);
        return userRepository.update(user);
    }

    @Override
    public Boolean deleteUser(Object id) {
        // Verifica se existe
        if (userRepository.findById(id) == null) {
            throw new UserNotFoundException(id);
            //return false;
        }
        userRepository.delete(id);
        return true;
    }
}