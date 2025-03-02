package com.bycrafter.core.accountmanagement.service.contact;

import com.bycrafter.core.accountmanagement.service.model.RoleResponseDto;

import java.util.List;

public interface RoleManagementService {

    RoleResponseDto addRole(String roleName);

    RoleResponseDto getRole(String id);

    List<RoleResponseDto> getRoles();
}
