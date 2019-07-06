package org.dzq.ssm.dao;

import java.util.List;

import org.dzq.ssm.pojo.Input;

public interface InputMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Input record);

    int insertSelective(Input record);


    Input selectByPrimaryKey(Integer id);

    List<Input> selectAllInput();
    int updateByPrimaryKeySelective(Input record);

    int updateByPrimaryKey(Input record);
}