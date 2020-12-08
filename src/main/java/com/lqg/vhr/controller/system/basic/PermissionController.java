package com.lqg.vhr.controller.system.basic;

import com.lqg.vhr.model.Menu;
import com.lqg.vhr.model.RespBean;
import com.lqg.vhr.model.Role;
import com.lqg.vhr.service.MenuService;
import com.lqg.vhr.service.system.basic.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissionController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    /**
     * 获取所有的角色
     * @return
     */
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    /**
     * 获取所有的菜单
     * @return
     */
    @GetMapping("/menus")
    private List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid){
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        if (menuService.updateMenuRole(rid,mids)){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if (roleService.addRole(role)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/role/{id}")
    public RespBean deleteRoleById(@PathVariable Integer id){
        if (roleService.deleteRoleById(id)==1){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败！");
    }
}
