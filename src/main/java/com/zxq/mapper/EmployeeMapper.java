package com.zxq.mapper;

import com.zxq.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll(String keyword);

    int updateByPrimaryKey(Employee record);

    void updateState(Long id);

    void saveRoles(@Param("eid") Long eid, @Param("rid") Long rid);
}