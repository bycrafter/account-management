package com.bycrafter.core.accountmanagement.service.contact;

import com.bycrafter.core.accountmanagement.service.model.UpdateUserRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserAddRequestDto;
import com.bycrafter.core.accountmanagement.service.model.UserResponseDto;

import java.util.List;

public interface UserManagementService {

    UserResponseDto addUser(UserAddRequestDto userAddRequestDto);
    UserResponseDto getUser(String id);
    List<UserResponseDto> getUsers();
    UserResponseDto updateUser(UpdateUserRequestDto updateUserRequestDto);
}
