package com.jing.controller;

import com.jing.dao.DepartmentDao;
import com.jing.dao.EmployeeDao;
import com.jing.entities.Department;
import com.jing.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Map;

/**
 * @author jing
 * @create 2020-03-09-15:48
 */
@Controller
public class empController {
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping(value = "/emps", method = RequestMethod.GET)
    public String getAll(Map<String, Object> map){
        Collection<Employee> allEmp = employeeDao.getAll();
        map.put("emps", allEmp);
        return "list";
    }
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String toAdd(Map<String, Object> map){
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("depts", depts);
        return "add";
    }
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String add(Employee e){
        employeeDao.save(e);
        return "redirect:/emps";
// 重定向应该到一个方法 直接到jsp他煤资源
    }
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id")Integer id, Map<String, Object> map){
        Employee employee = employeeDao.get(id);
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("emp", employee);
        map.put("depts", depts);
        return "update";
    }
    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String update(Employee employee){
        System.out.println(employee.getId());
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
