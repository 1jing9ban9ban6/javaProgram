package com.jing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jing.bean.Emp;
import com.jing.service.EmpService;
import com.jing.tool.pageTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author jing
 * @create 2020-03-14-11:40
 */
@Controller
public class EmpController {
    @Autowired
    private EmpService empService;
    @RequestMapping(value = "/emps/{pageNum}", method = RequestMethod.GET)
    public String getAllEmp(Map<String, Object> map, @PathVariable("pageNum")Integer pageNum, HttpServletRequest request){
        PageHelper.startPage(pageNum, 2);
        List<Emp> empList = empService.getAllEmp();
        PageInfo<Emp> pageInfo = new PageInfo<>(empList, 5);
        String page = pageTool.getPageInfo(pageInfo, request);
        System.out.println(page);
        map.put("emps", empList);
        map.put("page", page);
        return "list";
    }
}
