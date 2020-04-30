package com.jing.spring.book.service;

import com.jing.spring.book.dao.bookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jing
 * @create 2020-03-07-16:34
 */
@Service
public class bookServiceImpl implements bookService{
    @Autowired
    private bookDao bookDao;
    //pro 事务的传播行为 这个是不加新的事务 全部成功成功 不成功全部回滚
// rollbackFor（设置事务的回滚异常）
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, timeout = 3, rollbackFor = {})
    public void show(Integer bid, Integer sid, Integer uid){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer price = bookDao.selectBookById(bid);
        bookDao.updateBook(sid);
        bookDao.updateMoney(uid, price);
    }
// timeout 超过这个时间直接 回滚
// readOnly 指定当前事务中的操作是否为只读 spring 通知mysql mysql就把锁降低了 这样就快了
}
