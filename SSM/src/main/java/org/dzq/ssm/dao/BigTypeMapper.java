package org.dzq.ssm.dao;

import java.util.List;

import org.dzq.ssm.pojo.BigType;

public interface BigTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BigType record);

    int insertSelective(BigType record);

    List<BigType> selectAllBigType();
    BigType selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(BigType record);

    int updateByPrimaryKey(BigType record);
}