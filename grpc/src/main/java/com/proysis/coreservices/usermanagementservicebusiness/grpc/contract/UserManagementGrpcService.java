package com.proysis.coreservices.usermanagementservicebusiness.grpc.contract;

import com.bycrafter.core.usermanagement.proto.*;
import com.google.protobuf.Empty;
import com.proysis.coreservices.usermanagementservicebusiness.grpc.mapper.UserGrpcMapper;
import com.proysis.coreservices.usermanagementservicebusiness.service.contact.UserManagementService;
import com.proysis.coreservices.usermanagementservicebusiness.service.model.UserAddModel;
import com.proysis.coreservices.usermanagementservicebusiness.service.model.UserModel;
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
        UserAddModel userAddModel = mapper.toUserAddModel(request);
        var user = userManagementService.addUser(userAddModel);
        var response = mapper.toUserDetailResponse(user);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getUsers(Empty request, StreamObserver<UserListResponse> responseObserver) {
        List<UserModel> users = userManagementService.getUsers();
        List<UserResponse> userDetailResponseList = mapper.toUserListResponse(users);
        responseObserver.onNext(UserListResponse.newBuilder().addAllUserDetail(userDetailResponseList).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getUser(UserDetailRequest request, StreamObserver<UserResponse> responseObserver) {
        UserModel user = userManagementService.getUser(request.getId());
        UserResponse response = mapper.toUserDetailResponse(user);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(UpdateUserRequest request, StreamObserver<UserResponse> responseObserver) {
        UserModel userModel = mapper.toUserModel(request);
        var user = userManagementService.updateUser(userModel);
        var response = mapper.toUserDetailResponse(user);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
