package com.bycrafter.core.accountmanagement.grpc.mapper;

import com.bycrafter.core.accountmanagement.proto.UserRoleAddRequest;
import com.bycrafter.core.accountmanagement.proto.UserRoleResponse;
import com.bycrafter.core.accountmanagement.proto.UserWithRolesResponse;
import com.bycrafter.core.accountmanagement.service.model.UserRoleAddRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserRoleResponseDto;
import com.bycrafter.core.accountmanagement.service.model.UserWithRolesDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = RoleGrpcMapper.class, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface UserRoleGrpcMapper {
    UserRoleResponse toResponse(UserRoleResponseDto source);

    UserRoleAddRequestDto toRequest(UserRoleAddRequest source);

    UserWithRolesResponse toResponse(UserWithRolesDto source);


}
