package com.lqg.vhr.service;

import com.lqg.vhr.mapper.PoliticsstatusMapper;
import com.lqg.vhr.model.Politicsstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    /*政治面貌*/
public class PoliticsstatusService {

    @Autowired
    private PoliticsstatusMapper politicsstatusMapper;

    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusMapper.getAllPoliticsstatus();
    }
}
