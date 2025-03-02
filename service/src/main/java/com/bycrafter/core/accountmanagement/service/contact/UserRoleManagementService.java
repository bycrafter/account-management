package com.bycrafter.core.accountmanagement.service.contact;

import com.bycrafter.core.accountmanagement.service.model.UserRoleAddRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserRoleResponseDto;
import com.bycrafter.core.accountmanagement.service.model.UserWithRolesDto;

public interface UserRoleManagementService {
    UserRoleResponseDto addUserRole(UserRoleAddRequestDto userRoleAddRequestDto);

    UserWithRolesDto getUserRoles(String userId);
}
