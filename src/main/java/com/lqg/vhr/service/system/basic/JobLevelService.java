package com.lqg.vhr.service.system.basic;

import com.lqg.vhr.mapper.JoblevelMapper;
import com.lqg.vhr.model.JobLevel;
import com.lqg.vhr.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobLevelService {

    @Autowired
    private JoblevelMapper joblevelMapper;


    public List<JobLevel> getAllJobLevels() {
        return joblevelMapper.getAllJobLevels();
    }


    public int addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return joblevelMapper.insert(jobLevel);
    }

    public int editJobLevel(JobLevel jobLevel) {
        return joblevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public int deleteJobLevelById(Integer id) {
        return joblevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJobLevelByIds(Integer[] ids) {
        return joblevelMapper.deleteJobLevelByIds(ids);
    }
}
