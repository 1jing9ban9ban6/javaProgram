package com.jing.stroe.service.ServiceImpl;

import com.jing.stroe.dao.ProductDao;
import com.jing.stroe.dao.daoImpl.ProductDaoImpl;
import com.jing.stroe.domain.PageModel;
import com.jing.stroe.domain.Product;
import com.jing.stroe.service.ProductService;
import com.mchange.io.impl.EndsWithFilenameFilter;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    /**
     * 查找最新的商品
     * @return
     */
    @Override
    public List<Product> getNewProducts() throws Exception{
        ProductDao productDao = new ProductDaoImpl();
        List<Product> newProducts = productDao.getNewProducts();
        return newProducts;
    }

    /**
     * 查找最熱最新的商品
     * @return
     */
    @Override
    public List<Product> getHotProducts() throws Exception{
        ProductDao productDao = new ProductDaoImpl();
        List<Product> hotProducts = productDao.getHotProducts();
        return hotProducts;
    }

    /**
     * 根据id查找商品
     * @return
     */
    @Override
    public Product getProductById(String pid) throws Exception{
        ProductDao productDao = new ProductDaoImpl();
        Product p = productDao.getProductById(pid);
        return p;
    }

    /**
     * 首页分类商品列表 分类实现
     * @param cid
     * @param curNum
     * @return
     * @throws Exception
     */
    @Override
    public PageModel findProductsWithCidAndPage(String cid, int curNum) throws Exception {
        //1_创建PageModel对象,目的:携带分页参数 select count(*) from product where cid=?
        ProductDao productDao = new ProductDaoImpl();
        int totalRecords=productDao.findTotalNum(cid);
        PageModel pm=new PageModel(curNum, totalRecords, 6);
        //2_关联集合 SELECT * FROM product WHERE cid=1 LIMIT (当前页-1)*5,5;
        List<Product> list=productDao.findProductsWithCidAndPage(cid,pm.getStartIndex(),pm.getPageSize());
        pm.setList(list);
        //3_关联url
        pm.setUrl("ProductServlet?method=findProductsWithCidAndPage&cid="+cid);
        return pm;
    }

    @Override
    public PageModel findAllProductWithPage(int curNum) throws Exception {
        ProductDao productDao = new ProductDaoImpl();
        int total = productDao.findTotalNum();
        PageModel pm = new PageModel(curNum, total, 5);
        List<Product> list=productDao.findAllProductWithPage(pm.getStartIndex(),pm.getPageSize());
        pm.setList(list);
        pm.setUrl("AdminProductServlet?method=findAllProductWithPage");
        return pm;
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        ProductDao productDao = new ProductDaoImpl();
        productDao.saveProduct(product);
    }
}
