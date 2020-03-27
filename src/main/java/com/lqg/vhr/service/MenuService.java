package com.lqg.vhr.service;

import com.lqg.vhr.mapper.MenuMapper;
import com.lqg.vhr.model.Hr;
import com.lqg.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 李清钢
 * @date : 2020-03-25 17:03
 **/
@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getMenusByHrId() {
        //要传入id了，id从哪里来，我们登录的用户信息保存到security里面
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        //SecurityContextHolder里面有一个getContext()方法.getAuthentication()它里面的getPrincipal()，Principal它是当前登录的用户对象，然后强转成Hr对象再获取它里面的id
    }
}
