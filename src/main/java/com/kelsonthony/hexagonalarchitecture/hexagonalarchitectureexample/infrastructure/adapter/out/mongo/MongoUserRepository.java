package com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.infrastructure.adapter.out.mongo;

import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.domain.entity.UserMongoEntity;
import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.domain.port.out.UserRepository;
import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.application.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MongoUserRepository implements UserRepository {

    private final SpringDataMongoUserRepository springDataMongoUserRepository;
    private final ModelMapper modelMapper;

    public MongoUserRepository(SpringDataMongoUserRepository springDataMongoUserRepository,
                               ModelMapper modelMapper) {
        this.springDataMongoUserRepository = springDataMongoUserRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        List<UserDto> users = springDataMongoUserRepository.findAll(pageable)
                .getContent()
                .stream()
                .map(entity -> modelMapper.map(entity, UserDto.class))
                .collect(Collectors.toList());
        return new PageImpl<>(users, pageable, springDataMongoUserRepository.count());
    }


    @Override
    public UserDto findById(Object id) {
        return springDataMongoUserRepository.findById(String.valueOf(id))
                .map(entity -> modelMapper.map(entity, UserDto.class))
                .orElse(null);
    }

    @Override
    public UserDto save(UserDto userDto) {
        UserMongoEntity user = modelMapper.map(userDto, UserMongoEntity.class);
        return modelMapper.map(springDataMongoUserRepository.save(user), UserDto.class);
    }

    @Override
    public boolean existsByEmail(String email) {
        return springDataMongoUserRepository.existsByEmail(email);
    }

    @Override
    public UserDto update(UserDto userDto) {
        UserMongoEntity user = modelMapper.map(userDto, UserMongoEntity.class);
        return modelMapper.map(springDataMongoUserRepository.save(user), UserDto.class);
    }

    @Override
    public void delete(Object id) {
        springDataMongoUserRepository.deleteById(String.valueOf(id));

    }


}

