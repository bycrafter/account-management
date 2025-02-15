package com.proysis.coreservices.usermanagementservicebusiness.data.reposityory;

import com.proysis.coreservices.usermanagementservicebusiness.data.entity.UserEntity;
import datajpa.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {
}
