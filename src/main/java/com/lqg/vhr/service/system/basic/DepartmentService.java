package com.lqg.vhr.service.system.basic;

import com.lqg.vhr.mapper.DepartmentMapper;
import com.lqg.vhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询所有部门信息
     * @return
     */
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    /**
     *新增部分信息
     * @param department
     * @return
     */
    public int addDepartment(Department department) {
        department.setEnabled(true);
        return departmentMapper.insertSelective(department);
    }

    /**
     *修改部门信息
     * @param department
     * @return
     */
    public int updateDepartments(Department department) {
        return departmentMapper.updateByPrimaryKeySelective(department);
    }

    /**
     *根据id删除部门信息
     * @param department
     * @return
     */
    public int deleteDepartmentById(Department department) {
        return departmentMapper.deleteByPrimaryKey(department);
    }

    /**
     *根据id批量删除部门信息
     * @param ids
     * @return
     */
    public int deleteDepartmentByIds(Integer[] ids) {
        return departmentMapper.deleteDepartmentsByIds(ids);
    }
}
