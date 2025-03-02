package com.bycrafter.core.accountmanagement.grpc.mapper;

import com.bycrafter.core.accountmanagement.proto.RoleResponse;
import com.bycrafter.core.accountmanagement.proto.RoleResponseList;
import com.bycrafter.core.accountmanagement.service.model.RoleResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleGrpcMapper {

    RoleResponse toResponse(RoleResponseDto source);

    List<RoleResponse> toResponse(List<RoleResponseDto> source);

    default RoleResponseList toResponseList(List<RoleResponseDto> source) {
        return RoleResponseList.newBuilder().addAllRole(toResponse(source)).build();
    }
}
