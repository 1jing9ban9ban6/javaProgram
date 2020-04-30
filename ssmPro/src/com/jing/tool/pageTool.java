package com.jing.tool;

import com.github.pagehelper.PageInfo;
import com.jing.bean.Emp;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jing
 * @create 2020-03-14-17:57
 */
public class pageTool {
    public static String getPageInfo(PageInfo<Emp> pageInfo, HttpServletRequest request) {
        java.lang.String path = request.getContextPath()+"/";
        StringBuilder builder = new StringBuilder();
//        拼接首页
        builder.append("<a href='"+ path +"emps/1'>首页</a>&nbsp&nbsp");
//        拼接上一页
        if (pageInfo.isHasPreviousPage()){
            builder.append("<a href='"+ path +"emps/"+pageInfo.getPrePage()+"'>上一页</a>&nbsp&nbsp");
        } else {
            builder.append("上一页&nbsp&nbsp");
        }
//        拼接页码
        int[] nums = pageInfo.getNavigatepageNums();
        for (int i : nums) {
            if (i == pageInfo.getPageNum()){
                builder.append("<a style='color:red;' href='"+ path +"emps/"+i+"'>"+i+"</a>&nbsp&nbsp");
            } else {
                builder.append("<a href='"+ path +"emps/"+i+"'>"+i+"</a>&nbsp&nbsp");
            }
        }

//        拼接下一页
        if (pageInfo.isHasNextPage()){
            builder.append("<a href='"+ path +"emps/"+pageInfo.getNextPage()+"'>下一页</a>&nbsp&nbsp");
        } else {
            builder.append("下一页&nbsp&nbsp");
        }
//        拼接末页
        builder.append("<a href='"+ path +"emps/"+pageInfo.getPages()+"'>末页</a>&nbsp&nbsp");
        return builder.toString();
    }
}
