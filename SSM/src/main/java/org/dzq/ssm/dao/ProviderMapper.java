package org.dzq.ssm.dao;

import java.util.List;

import org.dzq.ssm.pojo.Provider;

public interface ProviderMapper {

    int deleteByPrimaryKey(Integer pid);

    int insert(Provider record);

    int insertSelective(Provider record);


    Provider selectByPrimaryKey(Integer pid);


    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKey(Provider record);
    List<Provider> selectAllProvider();
}