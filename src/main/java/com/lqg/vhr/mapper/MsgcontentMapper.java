package com.lqg.vhr.mapper;

import com.lqg.vhr.model.Msgcontent;
import org.springframework.stereotype.Repository;

@Repository
public interface MsgcontentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Msgcontent record);

    int insertSelective(Msgcontent record);

    Msgcontent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Msgcontent record);

    int updateByPrimaryKey(Msgcontent record);
}