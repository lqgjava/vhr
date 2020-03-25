package com.lqg.vhr.mapper;

import com.lqg.vhr.model.Empsalary;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpsalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Empsalary record);

    int insertSelective(Empsalary record);

    Empsalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Empsalary record);

    int updateByPrimaryKey(Empsalary record);
}