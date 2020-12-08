package com.lqg.vhr.service.system.basic;

import com.lqg.vhr.mapper.RoleMapper;
import com.lqg.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService{

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getAllRoles(){
        return roleMapper.getAllRoles();
    };

    public Integer addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.insert(role);
    }

    public int deleteRoleById(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }
}
