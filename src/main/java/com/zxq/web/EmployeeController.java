package com.zxq.web;

import com.zxq.domain.*;
import com.zxq.mapper.RoleMapper;
import com.zxq.service.EmployeeService;
import com.zxq.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleService roleService;
    @RequestMapping("employee")
    public String employee(){
        return "employee";
    }
    @RequestMapping("employeeList")
    @ResponseBody
    public PageList employeeList(QueryVo vo){
        System.out.println(vo);
        PageList pageList = employeeService.selectEmployees(vo);
        return pageList;
    }
    @RequestMapping("saveEmployee")
    @ResponseBody
    public AjaxRes saveEmployee(Employee employee){
        System.out.println(employee);
        AjaxRes ajaxRes = new AjaxRes();
      try {
          employeeService.saveEmployee(employee);
          ajaxRes.setSuccess(true);
          ajaxRes.setMsg("保存成功");
      }catch (Exception e){
          ajaxRes.setMsg("保存失败");
          ajaxRes.setSuccess(false);
      }
        return ajaxRes;
    }
    @RequestMapping("updateEmployee")
    @ResponseBody
    public AjaxRes updateEmployee(Employee employee){
        AjaxRes ajaxRes = new AjaxRes();
        try {
            employeeService.updateEmployee(employee);
            ajaxRes.setSuccess(true);
            ajaxRes.setMsg("更新成功");
        }catch (Exception e){
            ajaxRes.setMsg("更新失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }
    @RequestMapping("updateState")
    @ResponseBody
    public AjaxRes updateState(Long id){
        AjaxRes ajaxRes = new AjaxRes();
        try {
            employeeService.updateState(id);
            ajaxRes.setSuccess(true);
            ajaxRes.setMsg("更新成功");
        }catch (Exception e){
            ajaxRes.setMsg("更新失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }
    @RequestMapping("roleList")
    @ResponseBody
    public List<Role> roleList(){
        List<Role> roleList = roleService.getRoleList();
        return roleList;
    }
}
