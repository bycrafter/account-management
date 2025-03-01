package com.bycrafter.core.usermanagement.service.contact;

import com.bycrafter.core.usermanagement.service.model.UserAddModel;
import com.bycrafter.core.usermanagement.service.model.UserModel;

import java.util.List;

public interface UserManagementService {

    UserModel addUser(UserAddModel userAddModel);
    UserModel getUser(String id);
    List<UserModel> getUsers();
    UserModel updateUser(UserModel userModel);
}
