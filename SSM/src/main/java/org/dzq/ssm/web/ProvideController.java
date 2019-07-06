package org.dzq.ssm.web;

import javax.servlet.http.HttpServletRequest;

import org.dzq.ssm.pojo.Provider;
import org.dzq.ssm.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ssm")
public class ProvideController {
	@Autowired private ProviderService providerService;
	@RequestMapping("addProvider")
	public String addProvider(HttpServletRequest request){
		return "addGys";
	}
	@RequestMapping("AddProviderServlet")
	public String addProviderServlet(Provider provider,HttpServletRequest request){
		int id = (int)request.getSession().getAttribute("iddd");
		int effectNum = providerService.addProvider(provider);
		return "redirect:FindProByIdServlet?id="+id+"&flag=1";
	}
	
}
