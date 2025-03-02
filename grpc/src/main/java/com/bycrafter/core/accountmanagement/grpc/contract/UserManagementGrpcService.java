package com.bycrafter.core.accountmanagement.grpc.contract;

import com.bycrafter.core.accountmanagement.proto.*;
import com.bycrafter.core.accountmanagement.grpc.mapper.UserGrpcMapper;
import com.bycrafter.core.accountmanagement.service.contact.UserManagementService;
import com.bycrafter.core.accountmanagement.service.model.UpdateUserRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserAddRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserResponseDto;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
@RequiredArgsConstructor
public class UserManagementGrpcService extends UserManagementServiceGrpc.UserManagementServiceImplBase {

    private final UserManagementService userManagementService;
    private final UserGrpcMapper mapper;

    @Override
    public void addUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        UserAddRequestDto userAddRequestDto = mapper.toUserAddModel(request);
        var user = userManagementService.addUser(userAddRequestDto);
        var response = mapper.toUserDetailResponse(user);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getUsers(Empty request, StreamObserver<UserListResponse> responseObserver) {
        List<UserResponseDto> users = userManagementService.getUsers();
        List<UserResponse> userDetailResponseList = mapper.toUserListResponse(users);
        responseObserver.onNext(UserListResponse.newBuilder().addAllUserDetail(userDetailResponseList).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getUser(IdRequest request, StreamObserver<UserResponse> responseObserver) {
        UserResponseDto user = userManagementService.getUser(request.getId());
        UserResponse response = mapper.toUserDetailResponse(user);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(UpdateUserRequest request, StreamObserver<UserResponse> responseObserver) {
        UpdateUserRequestDto updateUserRequestDto = mapper.toUserModel(request);
        var user = userManagementService.updateUser(updateUserRequestDto);
        var response = mapper.toUserDetailResponse(user);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
