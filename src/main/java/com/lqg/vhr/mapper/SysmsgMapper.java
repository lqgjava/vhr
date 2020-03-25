package com.lqg.vhr.mapper;

import com.lqg.vhr.model.Sysmsg;
import org.springframework.stereotype.Repository;

@Repository
public interface SysmsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sysmsg record);

    int insertSelective(Sysmsg record);

    Sysmsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sysmsg record);

    int updateByPrimaryKey(Sysmsg record);
}