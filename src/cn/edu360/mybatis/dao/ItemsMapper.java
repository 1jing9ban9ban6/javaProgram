package cn.edu360.mybatis.dao;

import cn.edu360.mybatis.model.Items;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer itemsId);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer itemsId);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(Items record);
}