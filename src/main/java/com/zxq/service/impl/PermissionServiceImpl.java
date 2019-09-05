package com.zxq.service.impl;

import com.zxq.domain.Permission;
import com.zxq.mapper.PermissionMapper;
import com.zxq.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("PermissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> selectAll() {
        List<Permission> permissionList = permissionMapper.selectAll();
        return permissionList;
    }

    @Override
    public List<Permission> getPermissionByRid(Long rid) {
        return permissionMapper.getPermissionByRid(rid);
    }
}
