package org.dzq.ssm.web;

import java.util.List;

import org.dzq.ssm.pojo.Output;
import org.dzq.ssm.pojo.Products;
import org.dzq.ssm.service.OutputService;
import org.dzq.ssm.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ssm")
public class OutputController {
	@Autowired private ProductsService productsService;
	@Autowired private OutputService outputService;
	@RequestMapping(value="SearchOutputServlet")
	public String searchOutputServlet(Model model){
		
		List<Output> outputList = outputService.getOutputList();
		model.addAttribute("olist", outputList);
		return "searchOutput";
	}
	@RequestMapping(value="AddOutputServlet")
	public String addOutputServlet(Output output,Model model){
		
		int effectNum = outputService.InsertOutput(output);
		Products product = productsService.getProductByName(output.getName());
		product.setCount(product.getCount()-output.getPcount());
		Integer count = product.getCount();
		System.out.println(count);
		int effectNum2 = productsService.updateProduct(product);
		return "redirect:SearchOutputServlet";
	}
}
