package com.zxq.mapper;

import com.zxq.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(Role record);

    Role selectByPrimaryKey(Long rid);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    void updateRoleAndPermission(@Param("rid") Long rid, @Param("pid") Long pid);

    void deletePermission(Long rid);


    List<Role>  getRoleByEid(Long eid);
}