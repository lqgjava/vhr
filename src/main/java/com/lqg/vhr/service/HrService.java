package com.lqg.vhr.service;

import com.lqg.vhr.mapper.HrMapper;
import com.lqg.vhr.mapper.HrRoleMapper;
import com.lqg.vhr.model.Hr;
import com.lqg.vhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : 李清钢
 * @date : 2020-03-19 13:37
 **/
@Service
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;

    @Autowired
    HrRoleMapper hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(s);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        //登录成功之后，给用户设置角色
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(String keywords) {
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    /**
     * 这里面要做两个操作，先删除在增加
     * @param hrid
     * @param rids
     * @return
     */
    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRole(hrid,rids)==rids.length;
    }

    public Integer deleteHrById(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }
}
