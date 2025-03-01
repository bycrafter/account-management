package com.bycrafter.core.usermanagement.data.reposityory;

import com.bycrafter.core.usermanagement.data.entity.UserEntity;
import datajpa.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {
}
