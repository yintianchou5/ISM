package org.dzq.ssm.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dzq.ssm.pojo.Admin;
import org.dzq.ssm.pojo.BigType;
import org.dzq.ssm.pojo.Products;
import org.dzq.ssm.pojo.Provider;
import org.dzq.ssm.pojo.SmallType;
import org.dzq.ssm.service.AdminService;
import org.dzq.ssm.service.BigTypeService;
import org.dzq.ssm.service.ProductsService;
import org.dzq.ssm.service.ProviderService;
import org.dzq.ssm.service.SmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Controller
@RequestMapping("ssm")
public class AdminController {
	@Autowired 
	private ProviderService providerService;
	@Autowired
	private ProductsService productsService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private BigTypeService bigTypeService;
	@Autowired 
	private SmallTypeService smallTypeService;
	
	
	
	@RequestMapping(value="getadminlist",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAdminList(){
		Map<String,Object> modelMap=new HashMap<String,Object>();
		List<Admin> adminList = adminService.getAdminList();
		modelMap.put("adminList", adminList);
		return modelMap;
	}
	
	
	@RequestMapping(value="LoginServlet")
	public String checkLogin(Admin admin,HttpServletRequest request){
		
		
		
		boolean flag = adminService.checkLogin(admin.getName(), admin.getPwd());
		Admin admin2 = adminService.getAdminByAdmin(admin);
		if(flag==true) {
			request.getSession().setAttribute("superadmin", admin2);
			return "forward:main";
		}else {
			request.setAttribute("errMsg", "您输入的账号或密码错误！！");
			return "login";
		}
	}
	@RequestMapping(value="main")
	public String main(HttpServletRequest request,@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
		PageHelper.startPage(pageNum, pageSize,"createtime desc");
		List<Products> productsList = productsService.getProductsList();
		PageInfo<Products> pageInfo = new PageInfo<Products>(productsList);
		List<BigType> bigTypeList = bigTypeService.getBigTypeList();
		request.getSession().setAttribute("bigList",bigTypeList );
		request.setAttribute("pList", productsList);
		request.setAttribute("pageinfo", pageInfo);
			return "index";
	}
	
	@RequestMapping(value="GetAllAdminServlet")
	public String getAllAdminServlet(Model model){
		List<Admin> adminList = adminService.getAdminList();
		model.addAttribute("alist",adminList);
		return "showAdmin";
	}
	
	
	@RequestMapping(value="AddAdminServlet")
	public String addAdminServlet(Admin admin,Model model){
		int effectNum = adminService.insertAdmin(admin);
		if(effectNum>0) {
			model.addAttribute("Msg", "添加成功!!!");
			return "redirect:GetAllAdminServlet";
		}else {
			return "redirect:GetAllAdminServlet";
		}
	}
	@RequestMapping(value="DeleteAdminServlet")
	public String deleteAdminServlet(int id,Model model){
		int effectNum = adminService.deleteAdmin(id);
		if(effectNum>0) {
			return "redirect:GetAllAdminServlet";
		}else {
			model.addAttribute("errMsg", "删除失败");
			return "redirect:GetAllAdminServlet";
		}
	}
	@RequestMapping(value="FindAdminByIdServlet")
	public String findAdminByIdServlet(int id,HttpServletRequest request){
		request.getSession().setAttribute("id",id);
		Admin admin2 = adminService.getAdmin(id);
		request.setAttribute("admin2", admin2);
		System.out.println("------"+admin2);
		return "updateAdmin";
	}
	@RequestMapping(value="UpdateAdminServlet")
	public String updateAdminServlet(Admin admin,HttpServletRequest request){
		int  id =(int) request.getSession().getAttribute("id");
		System.out.println("++++++++++"+admin);
		admin.setId(id);
		int effectNum = adminService.updateAdmin(admin);
		if(effectNum>0) {
			return "redirect:GetAllAdminServlet";
		}else {
			request.setAttribute("errMsg", "修改失败");
			return "redirect:GetAllAdminServlet";
		}
	}
	@RequestMapping(value="FindProByIdServlet")
	public String findProByIdServlet(HttpServletRequest request){
		int  id = Integer.parseInt(request.getParameter("id"));
		request.getSession().setAttribute("iddd", id);
		Products product = productsService.selectByPrimaryKey(id);
		List<Provider> providerList = providerService.getProviderList();
		int  flag = Integer.parseInt(request.getParameter("flag"));
		SmallType smallType = smallTypeService.getSmallById(product.getSid());
		request.setAttribute("st", smallType);
		request.setAttribute("p", product);
		request.setAttribute("proList", providerList);
		if(flag==1) {
			return "input";
		}else if(flag==2) {
			return "output";
		}else if(flag==3) {
			return "showPro";
		}else {
			return "redirect:main";
		}
	}
	
	
	
	
//	@RequestMapping(value="LoginServlet")
//	public String checkLogin(Admin admin,HttpServletRequest request,@RequestParam(defaultValue="3")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
//		PageHelper.startPage(pageNum, 10);
//		List<Products> productsList = productsService.getProductsList();
//		PageInfo<Products> pageInfo = new PageInfo<Products>(productsList);
//		
//		
//		
//		boolean flag = adminService.checkLogin(admin.getName(), admin.getPwd());
//		List<BigType> bigTypeList = bigTypeService.getBigTypeList();
//		String URL="LoginServlet?pageNum="+pageNum;
//		
//		/*
//		 * try { admin.setName(new
//		 * String(admin.getName().getBytes("ISO-8859-1"),"utf-8")); } catch
//		 * (UnsupportedEncodingException e) { e.printStackTrace(); }
//		 */
//		
//		request.setAttribute("bigList",bigTypeList );
//		request.setAttribute("pList", productsList);
//		request.setAttribute("pageinfo", pageInfo);
//		Admin admin2 = adminService.getAdminByAdmin(admin);
//		if(flag==true) {
//			request.getSession().setAttribute("superadmin", admin2);
//			return "index";
//		}else {
//			request.setAttribute("errMsg", "您输入的账号或密码错误！！");
//			return "login";
//		}
//	}
}
