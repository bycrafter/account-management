package com.bycrafter.core.usermanagement.service.contact;

public interface UserRoleManagementService {
    void addUserRole(String userId, String roleId);

    void removeUserRole(String userId, String roleId);
}
