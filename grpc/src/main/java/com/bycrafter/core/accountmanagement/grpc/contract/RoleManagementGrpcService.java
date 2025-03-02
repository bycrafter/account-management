package com.bycrafter.core.accountmanagement.grpc.contract;

import com.bycrafter.core.accountmanagement.grpc.mapper.RoleGrpcMapper;
import com.bycrafter.core.accountmanagement.proto.*;
import com.bycrafter.core.accountmanagement.service.contact.RoleManagementService;
import com.bycrafter.core.accountmanagement.service.model.RoleResponseDto;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
@RequiredArgsConstructor
public class RoleManagementGrpcService extends RoleManagementServiceGrpc.RoleManagementServiceImplBase {

    private final RoleManagementService roleManagementService;
    private final RoleGrpcMapper mapper;

    @Override
    public void addRole(RoleRequest request, StreamObserver<RoleResponse> responseObserver) {
        RoleResponseDto roleResponseDto = roleManagementService.addRole(request.getName());
        responseObserver.onNext(mapper.toResponse(roleResponseDto));
        responseObserver.onCompleted();
    }

    @Override
    public void getRoles(Empty request, StreamObserver<RoleResponseList> responseObserver) {
        List<RoleResponseDto> roles = roleManagementService.getRoles();
        responseObserver.onNext(mapper.toResponseList(roles));
        responseObserver.onCompleted();
    }

    @Override
    public void getRole(IdRequest request, StreamObserver<RoleResponse> responseObserver) {
        RoleResponseDto role = roleManagementService.getRole(request.getId());
        responseObserver.onNext(mapper.toResponse(role));
        responseObserver.onCompleted();
    }
}
