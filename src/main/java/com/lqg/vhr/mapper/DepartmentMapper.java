package com.lqg.vhr.mapper;

import com.lqg.vhr.model.Department;
import com.lqg.vhr.model.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    int deleteByPrimaryKey(Department department);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartments();

    int deleteDepartmentsByIds(Integer[] ids);

    /**
     * 根据parentId查询所有部门
     * @param pid
     * @return
     */
    List<Department> getAllDepartmentsByParentId(int pid);
}