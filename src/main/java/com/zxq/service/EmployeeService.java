package com.zxq.service;

import com.zxq.domain.Employee;
import com.zxq.domain.PageList;
import com.zxq.domain.QueryVo;

public interface EmployeeService {
    public void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);

    void updateState(Long id);

    PageList selectEmployees(QueryVo vo);
}
