package com.bycrafter.core.accountmanagement.grpc.contract;

import com.bycrafter.core.accountmanagement.grpc.mapper.UserRoleGrpcMapper;
import com.bycrafter.core.accountmanagement.proto.*;
import com.bycrafter.core.accountmanagement.service.contact.UserRoleManagementService;
import com.bycrafter.core.accountmanagement.service.model.UserRoleAddRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserRoleResponseDto;
import com.bycrafter.core.accountmanagement.service.model.UserWithRolesDto;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class UserRoleManagementGrpcService extends UserRoleManagementServiceGrpc.UserRoleManagementServiceImplBase {

    private final UserRoleManagementService userRoleManagementService;
    private final UserRoleGrpcMapper userRoleGrpcMapper;

    @Override
    public void addUserRole(UserRoleAddRequest request, StreamObserver<UserRoleResponse> responseObserver) {
        UserRoleAddRequestDto requestDto = userRoleGrpcMapper.toRequest(request);
        UserRoleResponseDto responseDto = userRoleManagementService.addUserRole(requestDto);
        responseObserver.onNext(userRoleGrpcMapper.toResponse(responseDto));
        responseObserver.onCompleted();
    }

    @Override
    public void getUserRoles(IdRequest request, StreamObserver<UserWithRolesResponse> responseObserver) {
        UserWithRolesDto userRoles = userRoleManagementService.getUserRoles(request.getId());
        responseObserver.onNext(userRoleGrpcMapper.toResponse(userRoles));
        responseObserver.onCompleted();
    }
}
