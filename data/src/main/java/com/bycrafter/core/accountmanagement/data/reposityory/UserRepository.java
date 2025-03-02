package com.bycrafter.core.accountmanagement.data.reposityory;

import com.bycrafter.core.accountmanagement.data.entity.UserEntity;
import datajpa.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {

    @Query("SELECT u FROM users u LEFT JOIN FETCH u.roles WHERE u.id = :id")
    Optional<UserEntity> findRolesById(String id);
}
