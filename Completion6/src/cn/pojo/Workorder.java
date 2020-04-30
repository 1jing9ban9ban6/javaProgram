package cn.pojo;

import java.util.Date;

public class Workorder {
	
            private Integer id; //工单编号
            private Integer projectId; //项目编号
            private String executor; //执行人
            private String description; //任务描述
            private Integer orderLevel; //工单级别
            private Date createDate; //创建时间
            
            private String projectName; //项目名称
            
			public Integer getId() {
				return id;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			public Integer getProjectId() {
				return projectId;
			}
			public void setProjectId(Integer projectId) {
				this.projectId = projectId;
			}
			public String getExecutor() {
				return executor;
			}
			public void setExecutor(String executor) {
				this.executor = executor;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			public Integer getOrderLevel() {
				return orderLevel;
			}
			public void setOrderLevel(Integer orderLevel) {
				this.orderLevel = orderLevel;
			}
			public Date getCreateDate() {
				return createDate;
			}
			public void setCreateDate(Date createDate) {
				this.createDate = createDate;
			}
			public String getProjectName() {
				return projectName;
			}
			public void setProjectName(String projectName) {
				this.projectName = projectName;
			}       
			
}
