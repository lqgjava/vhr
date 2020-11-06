package com.lqg.vhr.controller.system.basic;

import com.lqg.vhr.model.Position;
import com.lqg.vhr.model.RespBean;
import com.lqg.vhr.service.system.basic.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : 李清钢
 * @date : 2020-04-03 15:21
 **/
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        if (positionService.addPosition(position)==1){
         return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    public RespBean updatePositions(@RequestBody Position position){
        if (positionService.updatePositions(position)==1){
            return RespBean.ok("修改成功！");
        }
        return RespBean.error("修改失败！");

    }

    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable Integer id){
        if(positionService.deletePositionById(id)==1){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deletePositionByIds(Integer[] ids){
        if (positionService.deletePositionByIds(ids) == ids.length){
            return RespBean.ok("删除成功");
        }else{
            return RespBean.error("删除失败");
        }
    }




}
