package com.lqg.vhr.controller.system.basic;

import com.lqg.vhr.model.Department;
import com.lqg.vhr.model.RespBean;
import com.lqg.vhr.service.system.basic.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")    /*用json传数据就要添加一个@RequestBody注解*/
    public RespBean addPosition(@RequestBody Department department){
            departmentService.addDep(department);
        if (department.getResult()==1){
            return RespBean.ok("添加成功!",department);
        }
        return RespBean.error("添加失败!");
    }

    /*@PutMapping("/")
    public RespBean updateDepartments(@RequestBody Department department){
        if (departmentService.updateDepartments(department)==1){
            return RespBean.ok("修改成功！");
        }
        return RespBean.error("修改失败！");

    }

    @DeleteMapping("/{id}")
    public RespBean deleteDepartmentById(@PathVariable Integer id){
        Department department = new Department();
        department.setId(id);
        departmentService.deleteDepartmentById(department);
        //对应下面的deleteDep返回的result
        if (department.getParentId() ==-2){
            return RespBean.error("该部门下有子部门，删除失败");
        }else if (department.getParentId()==-1){
            return RespBean.error("该部门下有员工，删除失败");
        }else if(department.getParentId() ==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deleteDepartmentByIds(Integer[] ids){
        if (departmentService.deleteDepartmentByIds(ids) == ids.length){
            return RespBean.ok("删除成功");
        }else{
            return RespBean.error("删除失败");
        }
    }*/

    @DeleteMapping("/{id}")
    public RespBean deleteDepById(@PathVariable Integer id ){
        Department department = new Department();
        department.setId(id);
        departmentService.deleteDepById(department);
        if (department.getResult()==-2){
            return RespBean.error("该部门下有子部门，删除失败！");
        }else if(department.getResult()==-1){
            return RespBean.error("该部门下有员工，删除失败！");
        }else if(department.getResult() == 1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败！");
    }
}
