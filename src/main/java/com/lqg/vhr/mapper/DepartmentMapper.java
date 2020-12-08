package com.lqg.vhr.mapper;

import com.lqg.vhr.model.Department;
import com.lqg.vhr.model.Position;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    /**
     * 根据parentId查询所有部门
     * @param pid
     * @return
     */
    List<Department> getAllDepartmentsByParentId(Integer pid);

    void addDep(Department dep);

    void deleteDepById(Department dep);

    List<Department> getAllDepartmentsWithOutChildren();

}