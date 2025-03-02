package com.bycrafter.core.accountmanagement.service.mapper;

import com.bycrafter.core.accountmanagement.data.entity.RoleEntity;
import com.bycrafter.core.accountmanagement.service.model.RoleResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResponseDto toDto(RoleEntity source);

    List<RoleResponseDto> toDto(List<RoleEntity> source);

    @Mapping(target = "name")
    RoleEntity toEntity(String name);
}
