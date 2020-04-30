package jing.mapper;

import jing.bean.Dept;
import jing.bean.Emp;

import java.util.List;

/**
 * @author jing
 * @create 2020-03-12-10:29
 */
public interface deptMapper {
    List<Emp> getAllEmp();
    Emp getEmpById(String eid);
    Dept getDeptById(String did);
    Dept getDeptEmpById(Integer did);
    List<Emp> getEmpByEid(String eid);
    Dept getDeptByIdStep(String did);
}
