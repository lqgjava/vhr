package com.lqg.vhr.mapper;

import com.lqg.vhr.model.JobLevel;
import com.lqg.vhr.model.RespBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoblevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobLevel record);

    int insertSelective(JobLevel record);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);

    List<JobLevel> getAllJobLevels();

    Integer deleteJobLevelByIds(@Param("ids")Integer[] ids);
}