package cn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dao.WorkorderMapper;
import cn.pojo.Project;
import cn.pojo.Workorder;


@Service
public class WorkorderServiceImpl implements WorkorderService {
	
	@Resource
	private WorkorderMapper workorderMapper;

	@Override
	public List<Project> getproject() throws Exception {
		return workorderMapper.getproject();
	}

	@Override
	public int add(Workorder workorder) throws Exception {
		return workorderMapper.add(workorder);
	}

	@Override
	public List<Workorder> getWorkorderList(Workorder workorder)
			throws Exception {
		return workorderMapper.getWorkorderList(workorder);
	}

}
