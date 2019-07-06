package org.dzq.ssm.service.impl;

import java.util.List;

import org.dzq.ssm.dao.ProductsMapper;
import org.dzq.ssm.pojo.Products;
import org.dzq.ssm.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductsServiceImpl implements ProductsService{
	@Autowired
	private ProductsMapper productsDao;
	@Override
	public int deleteroduct(Integer id) {
		int effectNum = productsDao.deleteProduct(id);
		return effectNum;
	}
	@Override
	public int insertProduct(Products product) {
		int effectNum = productsDao.insert(product);
		return effectNum;
	}
	@Override
	public int insertSelective(Products record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Products> getProductsList() {
		List<Products> productsList = productsDao.findAllProduct();
		return productsList;
	}
	@Override
	public Products selectByPrimaryKey(Integer id) {
		Products product = productsDao.selectByPrimaryKey(id);
		return product;
	}
	@Override
	public int updateByPrimaryKeySelective(Products record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateProduct(Products product) {
		int effectNum = productsDao.updateByPrimaryKeySelective(product);
		return effectNum;
	}
	@Override
	public int getProductsCount() {
		int count = productsDao.selectProductsCount();
		return count;
	}
	@Override
	public List<Products> getProductListByLike(Products product) {
		List<Products> productList = productsDao.selectByProduct(product);
		return productList;
	}
	@Override
	public Products getProductByName(String name) {
		Products product = productsDao.selectProductByName(name);
		return product;
	}

}
