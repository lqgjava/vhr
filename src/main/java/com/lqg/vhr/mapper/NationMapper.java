package com.lqg.vhr.mapper;

import com.lqg.vhr.model.Nation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nation record);

    int insertSelective(Nation record);

    Nation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);

    List<Nation> getAllNations();
}