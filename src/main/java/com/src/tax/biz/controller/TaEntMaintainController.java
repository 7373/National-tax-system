package com.icinfo.tax.biz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.tax.biz.dto.TaRiskDto;
import com.icinfo.tax.biz.model.TaEntMaintain;
import com.icinfo.tax.biz.service.ITaEntMaintainService;
@Controller
@RequestMapping("/entMaintain")
public class TaEntMaintainController extends BaseController {

	@Autowired
	ITaEntMaintainService taEntMaintainService;
	/**
	 * 进入事中排除维护
	 */
	@RequestMapping("/view")
	public ModelAndView view(String userID)throws Exception{
		ModelAndView mv = new ModelAndView("biz/ent_maintain_exp");
		mv.addObject("userID", userID);
		return mv;
	}
	/**
	 * 保存企业信息
	 * @author zjj
	 * @throws Exception 
	 * 
	 */
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(@RequestBody TaEntMaintain taEntMaintain,String userID) throws Exception{
		if(taEntMaintainService.insert(taEntMaintain)>0)
			return AjaxResult.success("提交成功");
		return AjaxResult.error("提交失败");
	}
	
	/**
	 * 获取企业数据
	 * @author ylr
	 * @throws Exception 
	 * 
	 */
	@RequestMapping("/doGetEntMaintainList")
	@ResponseBody
	public PageResponse<TaEntMaintain> doGetEntMaintainList(PageRequest request) throws Exception{
		List<TaEntMaintain> mainList = taEntMaintainService.queryPage(request);
		return new PageResponse<TaEntMaintain>(mainList);
	}
}
