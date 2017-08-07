package com.icinfo.tax.biz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 行业弹窗控制层
 * @author fanzhen
 * @date 20170502
 */
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.tax.biz.model.Industry;
import com.icinfo.tax.biz.service.IIndustryService;
@Controller
@RequestMapping("/industry")
public class IndustryController {
	
	@Resource(name="industryService")
	private IIndustryService industryService;

	@RequestMapping("/showIndustry")
	public String showIndustry(){
		return "biz/dept_checkbox_tree_select";
	}
	
	@RequestMapping("/registTreeList")
	@ResponseBody
	public List<Industry> registTreeList() throws Exception{
		List<Industry> list = industryService.findAllIndustry();
		return list;
	}
}
