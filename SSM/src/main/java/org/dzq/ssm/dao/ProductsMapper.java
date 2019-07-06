package org.dzq.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dzq.ssm.pojo.Products;

public interface ProductsMapper {

    int deleteProduct(Integer id);

    int insert(Products record);

    int insertSelective(Products record);
    
    List<Products> findAllProduct();
    int selectProductsCount();
    List<Products> selectByProduct(Products product);
    Products selectByPrimaryKey(Integer id);

    Products selectProductByName(String name);
    int updateByPrimaryKeySelective(Products record);

    int updateByPrimaryKey(Products record);
}