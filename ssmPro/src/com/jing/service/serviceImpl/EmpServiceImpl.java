package com.jing.service.serviceImpl;

import com.jing.bean.Emp;
import com.jing.mapper.EmpMapper;
import com.jing.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jing
 * @create 2020-03-14-11:41
 */
@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    private EmpMapper mapper;

    @Override
    public List<Emp> getAllEmp() {
        return mapper.getAllEmp();
    }

    @Override
    public Emp getEmpByEid(String eid) {
        Emp emp = mapper.getEmpByEid(eid);
        return emp;
    }

    @Override
    public void updateEmp(Emp emp) {
        mapper.updateEmp(emp);
    }
}
