package org.dzq.ssm.dao;

import java.util.List;

import org.dzq.ssm.pojo.Output;

public interface OutputMapper {

    int deleteByPrimaryKey(Integer oid);

    int insert(Output record);

    int insertSelective(Output record);


    Output selectByPrimaryKey(Integer oid);


    int updateByPrimaryKeySelective(Output record);

    int updateByPrimaryKey(Output record);
    List<Output> selectAllOutput();
}