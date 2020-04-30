package com.jing.weiming.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author jing
 * @create 2020-03-27-12:18
 */
@Repository
public class StockDaoImpl implements IStockDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 查询所有商品返回商品列表
     * @return
     */
    @Override
    public ArrayList<Map<String, Object>> getStockList() {
        //1、创建商品查询的SQL
        String sql = "select id AS sku_id, title, images, stock, price, indexes, own_spec " +
                "from tb_sku";

        //2、执行这个SQL
        ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) jdbcTemplate.queryForList(sql);

        //3、返回信息
        return list;
    }

    /**
     * 根据商品id查商品的详细信息
     * @param sku_id
     * @return
     */
    @Override
    public ArrayList<Map<String, Object>> getStockById(String sku_id) {
        //1、创建商品查询的SQL
        String sql = "select tb_sku.spu_id, tb_sku.title, tb_sku.images, tb_sku.stock, tb_sku.price, tb_sku.indexes, " +
                "tb_sku.own_spec, tb_sku.enable, tb_sku.create_time, tb_sku.update_time,tb_spu_detail.description," +
                "tb_sku.id AS sku_id,tb_spu_detail.special_spec " +
                "from tb_sku " +
                "INNER JOIN tb_spu_detail ON tb_spu_detail.spu_id=tb_sku.spu_id " +
                "where tb_sku.id = ?";

        //2、执行SQL
        ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) jdbcTemplate.queryForList(sql, sku_id);

        //3、返回信息
        return list;

    }

    @Override
    public synchronized Boolean insertLimitPolicy(Map<String, Object> policyInfo) {
        boolean result = false;
        //1、创建写入政策的语句
        String sql = "insert into tb_limit_policy (sku_id, quanty, price, begin_time, end_time) " +
                "Values (?, ?, ?, ?, ?)";

        //2、执行
        result = jdbcTemplate.update(sql, policyInfo.get("sku_id"), policyInfo.get("quanty"), policyInfo.get("price"),
                policyInfo.get("begin_time"), policyInfo.get("end_time"))==1;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql1 = "INSERT INTO tb_stock_storage (sku_id, quanty) VALUES ("+policyInfo.get("sku_id")+", "+policyInfo.get("quanty")+")";

        final String finalSql = sql1;

        result = jdbcTemplate.update(new PreparedStatementCreator() {

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(finalSql, Statement.RETURN_GENERATED_KEYS);
                return preparedStatement;
            }

        }, keyHolder)==1;
        if (!result){
            return false;
        }
        int new_id = keyHolder.getKey().intValue();
        String sql4 = "INSERT INTO tb_stock_storage_history (stock_storage_id, in_quanty, out_quanty) " +
                "VALUES (?, ?, ?)";
        result = jdbcTemplate.update(sql4, new_id, policyInfo.get("quanty"), 0)==1;
        if (!result){
            return false;
        }
        //3、返回信息
        return true;
    }
}
