package com.bycrafter.core.accountmanagement.service.mapper;

import com.bycrafter.core.accountmanagement.data.entity.UserEntity;
import com.bycrafter.core.accountmanagement.service.model.UpdateUserRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserAddRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    UserEntity toEntity(UserAddRequestDto source);

    UserEntity toEntity(UpdateUserRequestDto source);

    UserResponseDto toDto(UserEntity source);

    List<UserResponseDto> toDto(List<UserEntity> source);

}
