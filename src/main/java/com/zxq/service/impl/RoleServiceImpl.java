package com.zxq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zxq.domain.PageList;
import com.zxq.domain.Permission;
import com.zxq.domain.QueryVo;
import com.zxq.domain.Role;
import com.zxq.mapper.RoleMapper;
import com.zxq.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("RoleService")
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public PageList getRoles(QueryVo vo) {
        PageList pageList = new PageList();
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getRows());
        List<Role> roles = roleMapper.selectAll();
        pageList.setTotal(page.getTotal());
        pageList.setRows(roles);
        return pageList;
    }

    @Override
    public void saveRole(Role role) {
//        保存角色
        roleMapper.insert(role);
//        保存角色和权限的关系
        for (Permission permission : role.getPermissions()) {
            System.out.println(permission);
            roleMapper.updateRoleAndPermission(role.getRid(),permission.getPid());
        }

    }

    @Override
    public void updateRole(Role role) {
//        删除以前权限
        roleMapper.deletePermission(role.getRid());
//        重新添加权限
        for (Permission permission : role.getPermissions()) {
            roleMapper.updateRoleAndPermission(role.getRid(),permission.getPid());
        }
    }

    @Override
    public void deleteRole(Long rid) {
//        删除权限
        roleMapper.deletePermission(rid);
//        删除角色
        roleMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public List<Role> getRoleList() {
        List<Role> roleList = roleMapper.selectAll();
        return roleList;
    }

    @Override
    public List<Role> getRoleByEid(Long eid) {
        return  roleMapper.getRoleByEid(eid);
    }
}
