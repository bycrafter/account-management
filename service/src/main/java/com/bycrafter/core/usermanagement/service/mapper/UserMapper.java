package com.bycrafter.core.usermanagement.service.mapper;

import com.bycrafter.core.usermanagement.data.entity.UserEntity;
import com.bycrafter.core.usermanagement.service.model.UserAddModel;
import com.bycrafter.core.usermanagement.service.model.UserModel;
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
