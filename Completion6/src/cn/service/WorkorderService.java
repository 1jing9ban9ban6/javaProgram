package cn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pojo.Project;
import cn.pojo.Workorder;

public interface WorkorderService {
	/**
	 * 查询所有项目信息
	 * @return
	 * @throws Exception
	 */
	public List<Project> getproject() throws Exception;
	
	/**
	 * 增加工单
	 */
	public int  add(Workorder workorder) throws Exception;
	
	/**
	 * 查询所有工单信息
	 * @param student
	 * @return
	 */
	public List<Workorder> getWorkorderList(Workorder workorder)throws Exception;
	

}
