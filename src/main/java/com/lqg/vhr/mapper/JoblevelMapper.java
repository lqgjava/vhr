package com.lqg.vhr.mapper;

import com.lqg.vhr.model.Joblevel;
import org.springframework.stereotype.Repository;

@Repository
public interface JoblevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Joblevel record);

    int insertSelective(Joblevel record);

    Joblevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Joblevel record);

    int updateByPrimaryKey(Joblevel record);
}