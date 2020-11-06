package com.lqg.vhr.mapper;

import com.lqg.vhr.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    /**
     * 根据用户id查询菜单
     * @param hrid
     * @return
     */
    List<Menu> getMenusByHrId(Integer hrid);

    /**
     *
     * @return
     */
    List<Menu> getAllMenusWithRole();
}