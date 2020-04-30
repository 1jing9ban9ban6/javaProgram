var projectId=null;
var Project=null;
$(function(){	
	
	var path = $("#path").val();  
	projectId = $("#projectId");
	
	$.ajax({
		type:"GET",//请求类型
		url:path+"/projectlist.json",//请求的url
		data:{},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			if(data != null){
				var rid = $("#rid").val();
				projectId.html("");
				var options = "";
				for(var i = 0; i < data.length; i++){
					if(rid != null && rid != undefined && data[i].id == rid ){
						options += "<option selected=\"selected\" value=\""+data[i].id+"\" >"+data[i].projectName+"</option>";
					}else{
						options += "<option value=\""+data[i].id+"\" >"+data[i].projectName+"</option>";
					}
					
				}
				projectId.html(options);
			}
		},
	});
	
    $("#SubmitProject").on("click",function(){
    	Project=$("#projectId option:selected").val();
    	window.location.href=path+"/getProById.do?projectId="+Project;
    	
    });
	
});