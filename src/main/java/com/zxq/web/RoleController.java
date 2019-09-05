package com.zxq.web;

import com.zxq.domain.*;
import com.zxq.service.PermissionService;
import com.zxq.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("role")
    public String role(){
        return "role";
    }

    @RequestMapping("getRoles")
    @ResponseBody
    public PageList getRoles(QueryVo vo){
        PageList pageList = roleService.getRoles(vo);
        return pageList;
    }

    @RequestMapping("permissionList")
    @ResponseBody
    public List<Permission> permissionList(){
        System.out.println("permissionList");
        List<Permission> permissionList = permissionService.selectAll();
        return permissionList;
    }

    @RequestMapping("saveRole")
    @ResponseBody
    public AjaxRes saveRole(Role role){
        AjaxRes ajaxRes = new AjaxRes();
        try {
            roleService.saveRole(role);
            ajaxRes.setSuccess(true);
            ajaxRes.setMsg("保存成功");
        }catch (Exception e){
            ajaxRes.setMsg("保存失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    @RequestMapping("updateRole")
    @ResponseBody
    public AjaxRes updateRole(Role role){
        AjaxRes ajaxRes = new AjaxRes();
        try {
            roleService.updateRole(role);
            ajaxRes.setSuccess(true);
            ajaxRes.setMsg("更新成功");
        }catch (Exception e){
            ajaxRes.setMsg("更新失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    @RequestMapping("getPermissionByRid")
    @ResponseBody
    public  List<Permission> getPermissionByRid(Long rid){
        return  permissionService.getPermissionByRid(rid);

    }

    @RequestMapping("deleteRole")
    @ResponseBody
    public AjaxRes deleteRole(Long rid){
        System.out.println("delete from r_p where rid=#{rid}");
        AjaxRes ajaxRes = new AjaxRes();
        try {
            roleService.deleteRole(rid);
            ajaxRes.setSuccess(true);
            ajaxRes.setMsg("删除成功");
        }catch (Exception e){
            ajaxRes.setMsg("删除失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    @RequestMapping("getRoleByEid")
    @ResponseBody
    public List<Role> getRoleByEid(Long id){
        return  roleService.getRoleByEid(id);
    }
}
