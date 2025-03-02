package com.bycrafter.core.accountmanagement.service.impl;

import com.bycrafter.core.accountmanagement.data.entity.UserEntity;
import com.bycrafter.core.accountmanagement.data.reposityory.UserRepository;
import com.bycrafter.core.accountmanagement.service.contact.UserManagementService;
import com.bycrafter.core.accountmanagement.service.mapper.UserMapper;
import com.bycrafter.core.accountmanagement.service.model.UpdateUserRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserAddRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManagementServiceImpl implements UserManagementService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserResponseDto addUser(UserAddRequestDto userAddRequestDto) {
        UserEntity entity = userMapper.toEntity(userAddRequestDto);
        entity = userRepository.saveEntity(entity);
        return userMapper.toDto(entity);
    }

    @Override
    public UserResponseDto getUser(String id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("No user data found"));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserResponseDto> getUsers() {
        List<UserEntity> all = userRepository.findAll();
        return userMapper.toDto(all);
    }

    @Override
    public UserResponseDto updateUser(UpdateUserRequestDto updateUserRequestDto) {
        UserEntity entity = userMapper.toEntity(updateUserRequestDto);
        entity = userRepository.updateEntity(entity);
        return userMapper.toDto(entity);
    }
}
