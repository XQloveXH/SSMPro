package com.zxq.service;

import com.zxq.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> selectAll();

    List<Permission> getPermissionByRid(Long rid);
}
