package com.proysis.coreservices.usermanagementservicebusiness.grpc.mapper;

import com.bycrafter.core.usermanagement.proto.UpdateUserRequest;
import com.bycrafter.core.usermanagement.proto.UserRequest;
import com.bycrafter.core.usermanagement.proto.UserResponse;
import com.proysis.coreservices.usermanagementservicebusiness.service.model.UserAddModel;
import com.proysis.coreservices.usermanagementservicebusiness.service.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserGrpcMapper {
    UserGrpcMapper INSTANCE = Mappers.getMapper(UserGrpcMapper.class);

    UserAddModel toUserAddModel(UserRequest source);
    UserModel toUserModel(UpdateUserRequest source);
    UserResponse toUserDetailResponse(UserModel source);
    List<UserResponse> toUserListResponse(List<UserModel> source);

}
