package org.dzq.ssm.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dzq.ssm.pojo.Input;
import org.dzq.ssm.pojo.Products;
import org.dzq.ssm.service.InputService;
import org.dzq.ssm.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ssm")
public class InputController {
	@Autowired private ProductsService productsService;
	@Autowired private InputService inputService;
	@RequestMapping(value="AddInputServlet")
	public String addInputServlet(Input input,HttpServletRequest request){
		Date date = new Date();
		String pattern2 = "yyyy-MM-dd HH:mm:ss"; 
		SimpleDateFormat sdf = new SimpleDateFormat(pattern2);
		input.setInputtime(sdf.format(date));
		int effectNum = inputService.InsertInput(input);
		Products product = productsService.getProductByName(input.getName());
		product.setCount(product.getCount()+input.getPcount());
		product.setCreatetime(sdf.format(date));
		int effectNum2 = productsService.updateProduct(product);
		return "redirect:SearchInputServlet";
	}
	@RequestMapping(value="SearchInputServlet")
	public String sarchInputServlet(Model model){
		List<Input> inputList = inputService.getInputList();
		model.addAttribute("ilist", inputList);
		return "searchInput";
	}
}
