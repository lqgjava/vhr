package com.lqg.vhr.mapper;

import com.lqg.vhr.model.Appraise;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraiseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Appraise record);

    int insertSelective(Appraise record);

    Appraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);
}