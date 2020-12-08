package com.lqg.vhr.service;

import com.lqg.vhr.mapper.NationMapper;
import com.lqg.vhr.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService {

    @Autowired
    private NationMapper nationMapper;

    public List<Nation> getAllNations(){
        return nationMapper.getAllNations();
    }
}
