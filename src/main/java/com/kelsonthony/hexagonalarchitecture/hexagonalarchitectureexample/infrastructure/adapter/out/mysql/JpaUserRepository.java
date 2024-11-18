package com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.infrastructure.adapter.out.mysql;

import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.domain.entity.UserMysqlEntity;
import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.domain.port.out.UserRepository;
import com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.application.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
public class JpaUserRepository implements UserRepository {

    private final SpringDataJpaUserRepository springDataJpaUserRepository;

    private final ModelMapper modelMapper;

    public JpaUserRepository(SpringDataJpaUserRepository springDataJpaUserRepository,
                             ModelMapper modelMapper) {
        this.springDataJpaUserRepository = springDataJpaUserRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        //  return springDataJpaUserRepository.findAll(pageable);
        return modelMapper.map(springDataJpaUserRepository.findAll(pageable), Page.class);
    }

    @Override
    public UserDto findById(Object id) {
        // return springDataJpaUserRepository.findById(id).orElse(null);
        UserMysqlEntity userMysqlEntity = springDataJpaUserRepository.findById(Long.parseLong(id.toString())).orElse(null);
        if (userMysqlEntity != null) {
            return modelMapper.map(userMysqlEntity, UserDto.class);
        }
        return null;
    }

    @Override
    public UserDto save(UserDto userDto) {
        UserMysqlEntity userMysqlEntity = modelMapper.map(userDto, UserMysqlEntity.class);
        //return springDataJpaUserRepository.save(user);
        userMysqlEntity = springDataJpaUserRepository.save(userMysqlEntity);
        return modelMapper.map(userMysqlEntity, UserDto.class);
    }

    @Override
    public boolean existsByEmail(String email) {
        return springDataJpaUserRepository.existsByEmail(email);
    }

    @Override
    public UserDto update(UserDto userDtor) {
        UserMysqlEntity userMysqlEntity = modelMapper.map(userDtor, UserMysqlEntity.class);
        return modelMapper.map(springDataJpaUserRepository.save(userMysqlEntity), UserDto.class);
    }

    @Override
    public void delete(Object id) {
        springDataJpaUserRepository.deleteById(Long.parseLong(id.toString()));
    }
}