package com.bycrafter.core.accountmanagement.service.mapper;

import com.bycrafter.core.accountmanagement.data.entity.UserEntity;
import com.bycrafter.core.accountmanagement.data.entity.UserRoleEntity;
import com.bycrafter.core.accountmanagement.service.model.UserRoleAddRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserRoleResponseDto;
import com.bycrafter.core.accountmanagement.service.model.UserWithRolesDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    UserRoleResponseDto toDto(UserRoleEntity source);

    @Mapping(target = "user.id", source = "id")
    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.surname", source = "surname")
    @Mapping(target = "user.email", source = "email")
    @Mapping(target = "user.phone", source = "phone")
    UserWithRolesDto toDto(UserEntity source);

    UserRoleEntity toEntity(UserRoleAddRequestDto source);
}
