package com.lqg.vhr.service;

import com.lqg.vhr.mapper.MenuMapper;
import com.lqg.vhr.mapper.MenuRoleMapper;
import com.lqg.vhr.model.Hr;
import com.lqg.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : 李清钢
 * @date : 2020-03-25 17:03
 **/
@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    MenuRoleMapper menuRoleMapper;

    /**
     * 通过用户id获取菜单
     *
     * @return
     */
    public List<Menu> getMenusByHrId() {
        //要传入id了，id从哪里来，我们登录的用户信息保存到security里面
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        //SecurityContextHolder里面有一个getContext()方法.getAuthentication()它里面的getPrincipal()，Principal它是当前登录的用户对象，然后强转成Hr对象再获取它里面的id
    }

    /**
     * 获取所有的菜单角色   一对多 一个菜单项有多个角色
     *
     * @return
     */
//    @Cacheable
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    /**
     * 获取所有的菜单
     *
     * @return
     */
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        /*做两件事，第一件是删除，第二个是添加*/
         menuRoleMapper.deleteByRid(rid);
        Integer result = menuRoleMapper.insertRecord(rid,mids);
        return result==mids.length;
    }
}