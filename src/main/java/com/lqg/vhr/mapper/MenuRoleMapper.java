package com.lqg.vhr.mapper;

import com.lqg.vhr.model.MenuRole;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);
}