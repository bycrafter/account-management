package com.proysis.coreservices.usermanagementservicebusiness.service.mapper;

import com.proysis.coreservices.usermanagementservicebusiness.data.entity.UserEntity;
import com.proysis.coreservices.usermanagementservicebusiness.service.model.UserAddModel;
import com.proysis.coreservices.usermanagementservicebusiness.service.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toEntity(UserAddModel source);
    UserEntity toEntity(UserModel source);
    UserModel toUserModel(UserEntity source);
    List<UserModel> toUserModelList(List<UserEntity> source);

}
