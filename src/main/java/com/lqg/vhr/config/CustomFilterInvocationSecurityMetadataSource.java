package com.lqg.vhr.config;

import com.lqg.vhr.model.Menu;
import com.lqg.vhr.model.Role;
import com.lqg.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author : 李清钢
 * @date : 2020-03-31 15:36
 *
 * 这个类的作用：主要是根据用户传来的请求地址，分析出请求需要的角色
 *
 * 第一步的核心目的是根据用户的请求地址分析出来它所需要的角色，就是当前的请求需要哪些角色才能访问
 *
 * 第二步是去判断当前用户是否具备它需要的角色
 **/
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();
//    collenction:当前请求需要的角色  Object：实际上是一个filterInvocation对象
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //从filterInvocation里面可以获取当前请求的地址，拿到地址后，我就要拿这个地址去数据库里面跟这里的每一个菜单项去匹配，看是符合哪一个模式，然后再去看这个模式需要哪些角色
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
//      这个方法每次请求都会调用
        List<Menu> menus = menuService.getAllMenusWithRole();
        //比较request跟这menus里面的url是否一致 遍历menus 借助AntPathMatcher工具进行
        for (Menu menu : menus) {
//          String pattern:menus里面的规则
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                List<Role> roles = menu.getRoles();
                String[] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    str[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
//      没匹配上的统一登录之后就可以访问  "ROLE_LOGIN"只是一个标记
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
