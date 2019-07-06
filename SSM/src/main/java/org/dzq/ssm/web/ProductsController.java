package org.dzq.ssm.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dzq.ssm.pojo.Products;
import org.dzq.ssm.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ssm")
public class ProductsController {
	@Autowired
	private ProductsService productsService;
	@RequestMapping("GetProductsByKeyWordServlet")
	public String getProductsByKeyWordServlet(Products product,HttpServletRequest request){
		String name = request.getParameter("keyword");
		product.setName(name);
		List<Products> productList = productsService.getProductListByLike(product);
		request.getSession().setAttribute("pList", productList);
		return "searchResult";
	}
	@RequestMapping("GetAllBigType2Servlet")
	public String getAllBigType2Servlet(){
		return "newInput";
	}
	@RequestMapping("UpdateProductsServlet")
	public String updateProductsServlet(Products product,HttpServletRequest request){
		int effectNum = productsService.updateProduct(product);
		return "redirect:main";
	}
	@RequestMapping("AddProductsServlet")
	public String addProductsServlet(Products product,HttpServletRequest request){
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		product.setCreatetime(sdf.format(date));
		product.setState(1);
		product.setCount(0);
		int effectNum = productsService.insertProduct(product);
		return "redirect:main";
	}
	
}
