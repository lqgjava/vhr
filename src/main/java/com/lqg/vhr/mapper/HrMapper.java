package com.lqg.vhr.mapper;

import com.lqg.vhr.model.Hr;
import com.lqg.vhr.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("keywords") String keywords);
}