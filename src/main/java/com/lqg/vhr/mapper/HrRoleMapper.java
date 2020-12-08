package com.lqg.vhr.mapper;

import com.lqg.vhr.model.HrRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    void deleteByHrid(Integer hrid);

    Integer addRole(@Param("hrid") Integer hrid,@Param("rids") Integer[] rids);
}