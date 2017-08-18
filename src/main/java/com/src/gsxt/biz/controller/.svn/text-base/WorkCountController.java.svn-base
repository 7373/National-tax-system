package com.icinfo.tax.biz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.tax.biz.dto.TaRiskDto;
import com.icinfo.tax.biz.model.TaRiskMonth;
import com.icinfo.tax.biz.service.ITaRiskMonthService;
import com.icinfo.tax.biz.service.ITaRiskService;

/**
 * 工作量统计
 * 
 * @author zhuyong
 */
@RequestMapping(value="count")
@Controller
public class WorkCountController extends BaseController{

	@Autowired
	private ITaRiskService taRiskService;
	
	@Resource(name="taRiskMonthServiceImpl")
	private ITaRiskMonthService TaRiskMonthService;	
	/**
	 * 进入统计页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="view")
	public String view() throws Exception{
		return "biz/work_count";	
	}
	
	@ResponseBody
	@RequestMapping("/workCount")
	public AjaxResult workCount() throws Exception{
		Map<String,Integer> map = taRiskService.countRisk();
		return AjaxResult.success("查询成功", map);
	}
	
	@ResponseBody
	@RequestMapping("/peopleWorkCount")
	public AjaxResult peopleWorkCount(TaRiskDto dto) throws Exception{
		List<TaRiskDto> list = taRiskService.searchPeopleWorkCount(dto);
		for(TaRiskDto risk:list){
			if(risk.getBeforeRiskNum()==null){
				risk.setBeforeRiskNum(0);
			}
			if(risk.getBeforeRiskExamNum()==null){
				risk.setBeforeRiskExamNum(0);
			}
			if(risk.getAfterRiskNum()==null){
				risk.setAfterRiskNum(0);
			}
			if(risk.getAfterRiskExamNum()==null){
				risk.setAfterRiskExamNum(0);
			}
		}
		return AjaxResult.success("查询成功", list);
	}
	
	@ResponseBody
	@RequestMapping("/resultCount")
	public AjaxResult resultCount(TaRiskDto dto) throws Exception{
		Map<String,Object> map = taRiskService.searchResultCount(dto);
		return AjaxResult.success("查询成功", map);
	}
}








