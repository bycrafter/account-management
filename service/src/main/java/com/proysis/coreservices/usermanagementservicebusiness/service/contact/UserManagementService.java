package com.proysis.coreservices.usermanagementservicebusiness.service.contact;

import com.proysis.coreservices.usermanagementservicebusiness.service.model.UserAddModel;
import com.proysis.coreservices.usermanagementservicebusiness.service.model.UserModel;

import java.util.List;

public interface UserManagementService {

    UserModel addUser(UserAddModel userAddModel);
    UserModel getUser(String id);
    List<UserModel> getUsers();
    UserModel updateUser(UserModel userModel);
}
