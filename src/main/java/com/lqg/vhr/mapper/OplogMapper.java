package com.lqg.vhr.mapper;

import com.lqg.vhr.model.Oplog;
import org.springframework.stereotype.Repository;

@Repository
public interface OplogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Oplog record);

    int insertSelective(Oplog record);

    Oplog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Oplog record);

    int updateByPrimaryKey(Oplog record);
}