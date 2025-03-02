package com.bycrafter.core.accountmanagement.data.entity;

import datajpa.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "user_roles")
public class UserRoleEntity extends BaseEntity {

    @Column(nullable = false, name = "user_id")
    private String userId;
    @Column(nullable = false, name = "role_id")
    private String roleId;  
}
