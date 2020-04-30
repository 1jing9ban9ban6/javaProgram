package cn.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import cn.pojo.Project;
import cn.pojo.Workorder;
import cn.service.WorkorderService;


@Controller
public class WorkorderController {
	
	private Logger logger = Logger.getLogger(WorkorderController.class);
	
	@Autowired
	private WorkorderService workorderService;
	
	/**
	 * 异步获取项目
	 * @return
	 */
	@RequestMapping(value="/projectlist.json",method=RequestMethod.GET)
	@ResponseBody
	public List<Project> getProjectList(){
		List<Project>projectList = null;
		try {
			projectList = workorderService.getproject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("categoryList 数量:"+projectList.size());
		return projectList;
	}
	
	/**
	 * 增加工单
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/addsave.html", method = RequestMethod.POST)
	public String addWorkorder(Workorder workorder,HttpSession session){
		   workorder.setCreateDate(new Date());
		   try {
			   if(workorderService.add(workorder)>0)
			   session.setAttribute("tishi", "保存成功！");
			   return "redirect:/workorderlist.html";
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
		    session.setAttribute("tishi", "保存失败！");
		    return "add";
	}
	
	/**
	 * 查询所有工单信息
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/workorderlist.html")
	public String getStudent(Model model){
		List<Workorder> workoredrList = null;
		try {
			Workorder workorder=new Workorder();
			workoredrList=workorderService.getWorkorderList(workorder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("workoredrList",workoredrList);
		return "workorderlist";
	   }
	
	
	
	/**
	 * 获取项目的ID
	 * @param projectId
	 * @param session
	 * @return
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	@RequestMapping(value = "/getProById", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getProById(@RequestParam("projectId") String projectId,HttpSession session
    ) throws NumberFormatException, Exception {
		ModelAndView mv=new ModelAndView("/add"); //要跳转的页面
		mv.addObject("projectId", projectId);//保存项目ID
		return mv;
	}
}
