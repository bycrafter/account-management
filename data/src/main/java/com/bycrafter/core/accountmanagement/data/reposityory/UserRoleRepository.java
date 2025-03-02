package com.bycrafter.core.accountmanagement.data.reposityory;

import com.bycrafter.core.accountmanagement.data.entity.UserRoleEntity;
import datajpa.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends BaseRepository<UserRoleEntity> {
}
