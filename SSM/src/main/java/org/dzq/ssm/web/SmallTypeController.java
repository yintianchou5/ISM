package org.dzq.ssm.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dzq.ssm.pojo.SmallType;
import org.dzq.ssm.service.SmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ssm")
public class SmallTypeController {
	@Autowired
	private SmallTypeService smallTypeService;
	@RequestMapping("bybigfindsmall")
	@ResponseBody
	public List<SmallType> byBigFindSmall(HttpServletRequest request) {
		int bid = Integer.parseInt(request.getParameter("value"));
		List<SmallType> smallTypeList = smallTypeService.selectSmallByBigId(bid);
		return smallTypeList;
	}
}
