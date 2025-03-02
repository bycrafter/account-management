package com.bycrafter.core.accountmanagement.service.model;

import java.util.List;

public record UserWithRolesDto(UserResponseDto user, List<RoleResponseDto> roleList) {
}
