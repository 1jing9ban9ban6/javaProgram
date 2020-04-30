$(function() {
	add = $("#add");// 提交按钮

	var tijiao=0;//判断是否可以提交
	
	$("#executor").on("blur", function() {
		if ($("#executor").val() != null && $("#executor").val() != '') {
			tijiao=1;
		} else {
			alert("执行人不能为空！");
			tijiao=0;
		}
	});
    
	$("#description").on("blur", function() {
		if ($("#description").val() != null && $("#description").val() != '') {
			tijiao=1;
		} else {
			alert("任务描述不能为空！");
			tijiao=0;
		}
	});
	
	$("#orderLevel").on("blur", function() {
		if ($("#orderLevel").val() !=0) {
			tijiao=1;
		} else {
			alert("请选择级别！");
			tijiao=0;
		}
	});
	
	add.on("click", function() {
		if (confirm("是否确认提交数据")) {		
			if(tijiao==1){
				$("#addform").submit();
			}else{
				alert("请完善学员信息！");
			}
		}
	});
});
