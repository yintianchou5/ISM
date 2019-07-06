package org.dzq.ssm.web;

import javax.servlet.http.HttpServletRequest;

import org.dzq.ssm.pojo.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ssm")
public class MyController {
	@RequestMapping("index")
	private String index() {
		return "index";
	}
	
	@RequestMapping("login")
	private String login() {
		return "login";
	}
	
	@RequestMapping(value="addadmin")
	public String addAdmin(){
		return "addAdmin";
	}
	@RequestMapping(value="GetAllProductsServlet")
	public String getAllProductsServlet(){
		return "redirect:main";
	}
	
	
	
}
