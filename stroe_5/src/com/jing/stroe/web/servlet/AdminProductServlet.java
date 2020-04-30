package com.jing.stroe.web.servlet;

import com.jing.stroe.domain.Category;
import com.jing.stroe.domain.PageModel;
import com.jing.stroe.domain.Product;
import com.jing.stroe.service.CategoryService;
import com.jing.stroe.service.ProductService;
import com.jing.stroe.service.ServiceImpl.CategoryServiceImpl;
import com.jing.stroe.service.ServiceImpl.ProductServiceImpl;
import com.jing.stroe.utils.UUIDUtils;
import com.jing.stroe.utils.UploadUtils;
import com.jing.stroe.web.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;


@WebServlet(name = "AdminProductServlet")
public class AdminProductServlet extends BaseServlet {

    public String findAllProductWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取当前页码
        int curNum = Integer.parseInt(request.getParameter("num"));
        ProductService productService = new ProductServiceImpl();
        PageModel pm = productService.findAllProductWithPage(curNum);
        request.setAttribute("page", pm);
        return "/admin/product/list.jsp";
    }
    public String addProductUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 查询到全部的分类信息 因为要设置一个按钮
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> allCats = categoryService.findAllCats();
        request.setAttribute("allCats", allCats);
        return "/admin/product/add.jsp";
    }
    public String addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> map = new HashMap<>();
        Product product = new Product();
        try{
            // 获取所有请求正文，没对分割线放到一个集合里面
            DiskFileItemFactory fac = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(fac);
            List<FileItem> list = upload.parseRequest(request);
            // 遍历集合
            for(FileItem item:list){
                if(item.isFormField()){
//                    普通箱
                    map.put(item.getFieldName(),item.getString("utf-8"));
                }
                else {
                    // 获取到要保存的文件名称
                    String oldFileName = item.getName();
                    String newFileName = UploadUtils.getUUIDName(oldFileName);
                    // 获取到流对象
                    InputStream is = item.getInputStream();

                    String realPath = getServletContext().getRealPath("/products/3/");
                    String dir = UploadUtils.getDir(newFileName);
                    String path = realPath+dir;
                    // 在内存中声明目录
                    File newDir = new File(path);
                    if(!newDir.exists()){
                        newDir.mkdirs();
                    }
                    // 在服务端创建一个该空文件
                    File finalFile=new File(newDir, newFileName);
                    if(!finalFile.exists()){
                        finalFile.createNewFile();
                    }
                    // 从流中读入然后在写到文件中
                    FileOutputStream os = new FileOutputStream(finalFile);
                    IOUtils.copy(is,os);
                    IOUtils.closeQuietly(is);
                    IOUtils.closeQuietly(os);
                    // 准备在数据库中写路径
                    map.put("pimage", "stproducts/3/"+dir+"/"+finalFile);
                    // 最后利用beanUtil在数据库中创建对象
                    BeanUtils.populate(product, map);
                    product.setPid(UUIDUtils.getId());
                    product.setPdate(new Date());
                    product.setPflag(0);

                    ProductService productService = new ProductServiceImpl();
                    productService.saveProduct(product);
                    response.sendRedirect("/store_5/AdminProductServlet?method=findAllProductWithPage&num=1");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
