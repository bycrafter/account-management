package com.bycrafter.core.accountmanagement.service.impl;

import com.bycrafter.core.accountmanagement.data.entity.RoleEntity;
import com.bycrafter.core.accountmanagement.data.reposityory.RoleRepository;
import com.bycrafter.core.accountmanagement.service.contact.RoleManagementService;
import com.bycrafter.core.accountmanagement.service.mapper.RoleMapper;
import com.bycrafter.core.accountmanagement.service.model.RoleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleManagementServiceImpl implements RoleManagementService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;


    @Override
    public RoleResponseDto addRole(String roleName) {
        RoleEntity role = roleMapper.toEntity(roleName);
        role = roleRepository.saveEntity(role);
        return roleMapper.toDto(role);
    }

    @Override
    public RoleResponseDto getRole(String id) {
        RoleEntity byId = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("No role data found"));
        return roleMapper.toDto(byId);
    }

    @Override
    public List<RoleResponseDto> getRoles() {
        List<RoleEntity> all = roleRepository.findAll();
        return roleMapper.toDto(all);
    }
}
