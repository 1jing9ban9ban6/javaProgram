package jing.mapper;

import jing.bean.Emp;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @author jing
 * @create 2020-03-12-10:30
 */
public interface empMapper {
//    根据eid 查询员工信息
    Emp getEmpById(Integer eid);
//    获取所有员工信息
    List<Emp> getAllEmp();
//    添加员工信息
    Integer addEmp(Emp emp);
//    修改员工信息
    void update(Emp emp);
//   删除员工
    void deleteEmp(Integer eid);
    @MapKey("eid")
    Map<String, Emp> getAllEmpMap();
}
