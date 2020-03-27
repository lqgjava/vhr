package com.lqg.vhr.controller;

import com.lqg.vhr.model.Menu;
import com.lqg.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : 李清钢
 * @date : 2020-03-25 16:55
 **/
@RestController
@RequestMapping("/system/config")
public class SysConfigController {

    @Autowired
    MenuService menuService;;

    @GetMapping("/menu")
    public List<Menu> getMenusByHrId(){
        return menuService.getMenusByHrId();
    }
}
