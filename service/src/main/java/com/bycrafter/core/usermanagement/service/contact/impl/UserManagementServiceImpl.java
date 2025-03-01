package com.bycrafter.core.usermanagement.service.contact.impl;

import com.bycrafter.core.usermanagement.data.entity.UserEntity;
import com.bycrafter.core.usermanagement.data.reposityory.UserRepository;
import com.bycrafter.core.usermanagement.service.contact.UserManagementService;
import com.bycrafter.core.usermanagement.service.mapper.UserMapper;
import com.bycrafter.core.usermanagement.service.model.UserAddModel;
import com.bycrafter.core.usermanagement.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    private final UserRepository userRepository;

    @Autowired
    public UserManagementServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel addUser(UserAddModel userAddModel) {
        UserEntity entity = UserMapper.INSTANCE.toEntity(userAddModel);
        entity = userRepository.saveAndFlush(entity);
        return UserMapper.INSTANCE.toUserModel(entity);
    }

    @Override
    public UserModel getUser(String id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("No user data found"));
        return UserMapper.INSTANCE.toUserModel(user);
    }

    @Override
    public List<UserModel> getUsers() {
        List<UserEntity> all = userRepository.findAll();
        return UserMapper.INSTANCE.toUserModelList(all);
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        UserEntity entity = UserMapper.INSTANCE.toEntity(userModel);
        entity = userRepository.update(entity);
        return UserMapper.INSTANCE.toUserModel(entity);
    }
}
