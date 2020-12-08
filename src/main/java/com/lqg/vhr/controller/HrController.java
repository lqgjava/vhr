package com.lqg.vhr.controller;

import com.lqg.vhr.model.Hr;
import com.lqg.vhr.model.RespBean;
import com.lqg.vhr.model.Role;
import com.lqg.vhr.service.HrService;
import com.lqg.vhr.service.system.basic.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;

    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords){
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr){
        if (hrService.updateHr(hr)==1){
            return RespBean.ok("修改成功！");
        }
        return RespBean.error("修改失败！");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    /**
     * 用来更新hr角色的
     */
    @PutMapping("/roles")
    public RespBean updateHrRole(Integer hrid,Integer[] rids){
        if (hrService.updateHrRole(hrid,rids)){
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id){
        if (hrService.deleteHrById(id)==1){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败！");
    }
}
