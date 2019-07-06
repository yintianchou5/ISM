package org.dzq.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dzq.ssm.pojo.Products;

public interface ProductsService {
	int deleteroduct(Integer id);

    int insertProduct(Products product);

    int insertSelective(Products record);
    
    List<Products> getProductsList();

    Products selectByPrimaryKey(Integer id);
    int getProductsCount();
    Products getProductByName(String name);
    int updateByPrimaryKeySelective(Products record);

    int updateProduct(Products product);
    
    List<Products> getProductListByLike(Products product);
}
