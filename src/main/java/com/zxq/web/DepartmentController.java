package com.zxq.web;

import com.zxq.domain.Department;
import com.zxq.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("departList")
    @ResponseBody
    public List<Department> departList(){
        System.out.println("测试Github");
        return departmentService.getAllDepartment();

    }
}
