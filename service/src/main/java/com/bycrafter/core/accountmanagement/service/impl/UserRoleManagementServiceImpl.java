package com.bycrafter.core.accountmanagement.service.impl;

import com.bycrafter.core.accountmanagement.data.entity.UserEntity;
import com.bycrafter.core.accountmanagement.data.entity.UserRoleEntity;
import com.bycrafter.core.accountmanagement.data.reposityory.UserRepository;
import com.bycrafter.core.accountmanagement.data.reposityory.UserRoleRepository;
import com.bycrafter.core.accountmanagement.service.contact.UserRoleManagementService;
import com.bycrafter.core.accountmanagement.service.mapper.UserRoleMapper;
import com.bycrafter.core.accountmanagement.service.model.UserRoleAddRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserRoleResponseDto;
import com.bycrafter.core.accountmanagement.service.model.UserWithRolesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleManagementServiceImpl implements UserRoleManagementService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final UserRoleMapper userRoleMapper;

    @Override
    public UserRoleResponseDto addUserRole(UserRoleAddRequestDto userRoleAddRequestDto) {
        UserRoleEntity entity = userRoleMapper.toEntity(userRoleAddRequestDto);
        entity = userRoleRepository.saveEntity(entity);
        return userRoleMapper.toDto(entity);
    }

    @Override
    public UserWithRolesDto getUserRoles(String userId) {
        UserEntity user = userRepository.findRolesById(userId).orElseThrow(() -> new RuntimeException("No user data found"));
        return userRoleMapper.toDto(user);
    }
}
