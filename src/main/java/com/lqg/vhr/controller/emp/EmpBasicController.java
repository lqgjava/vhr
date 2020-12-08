package com.lqg.vhr.controller.emp;

import com.lqg.vhr.model.*;
import com.lqg.vhr.service.EmployeeService;
import com.lqg.vhr.service.NationService;
import com.lqg.vhr.service.PoliticsstatusService;
import com.lqg.vhr.service.system.basic.DepartmentService;
import com.lqg.vhr.service.system.basic.JobLevelService;
import com.lqg.vhr.service.system.basic.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private NationService nationService;
    @Autowired
    private PoliticsstatusService politicsstatusService;
    @Autowired
    private JobLevelService jobLevelService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;
    /**
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size,String keyword){
        return employeeService.getEmployeeByPage(page,size,keyword);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee){
        if (employeeService.addJobLevel(employee)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败！");
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations(){
        return nationService.getAllNations();
    }

    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus(){
        return politicsstatusService.getAllPoliticsstatus();
    }

    @GetMapping("/joblevels")
    public List<JobLevel> getAllJobLevels(){
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }

    @GetMapping("/maxWorkID")
    public RespBean maxWorkID(){
        RespBean respBean = RespBean.build().setStatus(200)
                .setObj(String.format("%08d", employeeService.maxWorkID() + 1));
        return respBean;
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpByEid(@PathVariable Integer id){
        if (employeeService.deleteEmpByEid(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee employee){
        if (employeeService.updateEmp(employee)==1){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败！");
    }


}
