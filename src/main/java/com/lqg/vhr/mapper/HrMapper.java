package com.lqg.vhr.mapper;

import com.lqg.vhr.model.Hr;
import org.springframework.stereotype.Repository;

@Repository
public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    Hr loadUserByUsername(String username);
}