package org.dzq.ssm.dao;

import java.util.List;

import org.dzq.ssm.pojo.SmallType;

public interface SmallTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SmallType record);

    int insertSelective(SmallType record);


    SmallType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmallType record);

    int updateByPrimaryKey(SmallType record);
    
    
    
    List<SmallType> selectSmallByBigId(int bid);
    SmallType selectSmallTypeById(int id);
}