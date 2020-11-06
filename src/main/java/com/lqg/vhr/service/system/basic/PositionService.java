package com.lqg.vhr.service.system.basic;

import com.lqg.vhr.mapper.PositionMapper;
import com.lqg.vhr.model.Position;
import com.lqg.vhr.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author : 李清钢
 * @date : 2020-04-03 15:27
 **/
@Service
public class PositionService {

    @Autowired
    PositionMapper positionMapper;

    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }

    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    public Integer updatePositions(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePositionById(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除职位
     * @param ids
     * @return
     */
    public int deletePositionByIds(Integer[] ids) {
        for (Integer id : ids) {
            System.out.println("id=========================================="+id);
        }
        return positionMapper.deletePositionByIds(ids);
    }
}
