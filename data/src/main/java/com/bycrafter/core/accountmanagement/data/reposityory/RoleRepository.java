package com.bycrafter.core.accountmanagement.data.reposityory;

import com.bycrafter.core.accountmanagement.data.entity.RoleEntity;
import datajpa.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseRepository<RoleEntity> {
}
