package com.zxq.service;

import com.zxq.domain.PageList;
import com.zxq.domain.QueryVo;
import com.zxq.domain.Role;

import java.util.List;

public interface RoleService {
    PageList getRoles(QueryVo vo);

    void saveRole(Role role);

    void updateRole(Role role);

     void deleteRole(Long rid);

    List<Role> getRoleList();

    List<Role> getRoleByEid(Long eid);
}
