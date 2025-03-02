package com.bycrafter.core.accountmanagement.grpc.mapper;

import com.bycrafter.core.accountmanagement.proto.UpdateUserRequest;
import com.bycrafter.core.accountmanagement.proto.UserRequest;
import com.bycrafter.core.accountmanagement.proto.UserResponse;
import com.bycrafter.core.accountmanagement.service.model.UpdateUserRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserAddRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserGrpcMapper {
    UserAddRequestDto toUserAddModel(UserRequest source);
    UpdateUserRequestDto toUserModel(UpdateUserRequest source);
    UserResponse toUserDetailResponse(UserResponseDto source);
    List<UserResponse> toUserListResponse(List<UserResponseDto> source);

}
