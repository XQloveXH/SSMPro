package com.zxq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zxq.domain.Employee;
import com.zxq.domain.PageList;
import com.zxq.domain.QueryVo;
import com.zxq.domain.Role;
import com.zxq.mapper.EmployeeMapper;
import com.zxq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("EmployeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
   @Autowired
   private EmployeeMapper employeeMapper;
    @Override
    public PageList selectEmployees(QueryVo vo) {
        System.out.println("来到service");
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getRows());
        String keyword = vo.getKeyword();
        List<Employee> employeeList = employeeMapper.selectAll(keyword);
        PageList pageList = new PageList();
        pageList.setTotal(page.getTotal());
        pageList.setRows(employeeList);
        System.out.println("keyword");
        return pageList;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employee.setState(true);
//        保存员工
        employeeMapper.insert(employee);
//        保存员工的角色
        for (Role employeeRole : employee.getRoles()) {

            employeeMapper.saveRoles(employee.getId(),employeeRole.getRid());
        }

    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
        System.out.println("更新成功");
    }

    @Override
    public void updateState(Long id) {
        employeeMapper.updateState(id);
    }

}
