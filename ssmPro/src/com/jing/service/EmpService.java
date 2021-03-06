package com.jing.service;

import com.jing.bean.Emp;

import java.util.List;

/**
 * @author jing
 * @create 2020-03-14-11:41
 */
public interface EmpService {
    //    获取所有员工信息
    List<Emp> getAllEmp();
    //    根据id查找员工信息
    Emp getEmpByEid(String eid);
    //    修改员工信息
    void updateEmp(Emp emp);
}
