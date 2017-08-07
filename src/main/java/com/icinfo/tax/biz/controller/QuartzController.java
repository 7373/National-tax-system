package com.icinfo.tax.biz.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.tax.biz.dto.TaRiskDto;
import com.icinfo.tax.biz.model.ModelVar;
import com.icinfo.tax.biz.model.TaRiskMonth;
import com.icinfo.tax.biz.service.IModelVarService;
import com.icinfo.tax.biz.service.IQuartzService;
import com.icinfo.tax.biz.service.ITaRiskMonthService;
import com.icinfo.tax.biz.service.ITaRiskService;
import com.icinfo.tax.support.DateUtil;
import com.icinfo.tax.support.UUIDUtils;


/**
 * 定时任务控制器
 * 
 * @author zhuyong
 */
@Controller
@RequestMapping(value="quartz")
public class QuartzController extends BaseController{
	
	@Autowired
	private ITaRiskMonthService taRiskMonthService;
	@Autowired
	private ITaRiskService taRiskService;
	@Autowired
	private IQuartzService quartzService;
	@Autowired
	private IModelVarService modelVarService;
	
	/**
	 * 全表初始化ModelVar
	 * 
	 * @author ylr
	 */
	@RequestMapping(value="initModelVar")
	@ResponseBody
	public void initModelVar() throws Exception{
		System.out.println("\n---------- init model var start---------");
		//事前风险数据初始化准备
		System.out.println("------------事前风险数据初始化准备");
		modelVarService.doInitModelVar();
		System.out.println("--------initTaRiskAdvance");
		//初始化事前风险
		modelVarService.initAdvanceTaRisk();
		System.out.println("------------modelvar表fxgrade更新分数");
		System.out.println("------------根据分数算出风险程度-高危-中度-低微");
		System.out.println("------------根据给定excel条件算出高危风险");
		System.out.println("------------删除低微风险");
		System.out.println("------------根据给定条件添加风险点");
		System.out.println("------------根据添加风险点计算风险点数量");
		modelVarService.doInitFxStatusDetail();
		System.out.println("------------删除所有排除风险企业");
		taRiskService.deleteMaintainEnt();
		System.out.println("\n----------init model var end---------");
		
	}
	/**
	 * 定时任务-风险计算(不带参数)
	 * 
	 * @author zhuyong
	 */
	@RequestMapping(value="/main")
	public void RiskAfter(){
		jobOfRisk(null);
	}
	/**
	 * 定时任务-风险计算(带参数)
	 * 
	 * @author zhuyong
	 */
	@RequestMapping(value="/main/{riskMonth}")
	public void RiskAfterForObj(@PathVariable String riskMonth){
		if(StringUtils.isNotBlank(riskMonth) && riskMonth.matches("^[1-9][0-9]{3}((0[1-9])|(1[012]))$"))
			jobOfRisk(riskMonth);
		else{
			System.out.println("日期格式不正确！");
		}
	}

	public void jobOfRisk(String riskMonth){
		System.out.println("\n----------init current start---------");
		try {
			
			Date date = new Date();
			if(StringUtils.isNotBlank(riskMonth)){
				SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
				date = DateUtil.getMonth(format.parse(riskMonth),1).getTime();
			}
			//判断是否本月已执行计算
			Map<String,Object> qryMap = new HashMap<String,Object>();
			
			qryMap.put("riskMonth",quartzService.doGetRiskMonth(date));
			if(taRiskMonthService.findTaRiskMonthList(qryMap).size()>0) return;
			
			//若本月没有计算则新插入月份表中
			TaRiskMonth taRiskMonth = new TaRiskMonth();
			taRiskMonth.setMonId(UUIDUtils.randomUUID());
			taRiskMonth.setCreateTime(new Date());
			taRiskMonth.setRiskMonth(quartzService.doGetRiskMonth(date));
			taRiskMonthService.insert(taRiskMonth);
			
			//将所有需要的nsrsbh插入risk表
			taRiskService.insertForBaseInfo(qryMap);
			
			//获取所有需要计算的nsrsbh
			qryMap.put("riskType","CURRENT");
			qryMap.put("dateStartBG",DateUtil.getLastDayForMonth(DateUtil.getMonth(date,-3)));
			qryMap.put("dateStart",DateUtil.getLastDayForMonth(DateUtil.getMonth(date,-2)));
			qryMap.put("dateEnd",DateUtil.getFirstDayForMonth(DateUtil.getMonth(date,0)));
			qryMap.put("date", date);//所要计算的月份时间
			//遍历所有的nsrsbh
			quartzService.ergodicNsrsbh(qryMap);
			
			//删除风险项为0的企业
			taRiskService.deleteRiskNum();
			
			//删除所有排除风险的企业
			taRiskService.deleteMaintainEnt();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("\n----------init current exception---------");

		}
		System.out.println("\n----------init current end---------");

	}
	/**
	 * 增量更新事前风险分数
	 * 
	 * @author ylr
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public void updateTaRiskForIncrement()throws Exception{
		//1、获取事前风险增量数据
		Map<String,Object> paramMap = new HashMap<String,Object>();
		Date date = DateUtil.getNdaylaterDate(new Date(), -1);
		paramMap.put("lrrqStart", DateUtil.getdayStartDate(date));
		paramMap.put("lrrqEnd", DateUtil.getdayEndDate(date));
		int num = quartzService.selectCountForBGModelVar(paramMap);
		List<ModelVar> modelVarList;
		if(num>0) {
			//2、ModelVar表更新---
			int pageSize=2000;
			for(int i=0;i<num;i+=2000){//先删除
				paramMap.put("skipResult", i);
				paramMap.put("pageSize", pageSize);
				modelVarList = modelVarService.getModelVarList(paramMap);
				System.out.println("--------------------hr;kasjdsakl-----");
					modelVarService.deleteModelVarByNsrsbh(modelVarList);
			}
//			modelVarService.insertIncrementModelVar(paramMap);//插入增量数据
			//事前风险分数更新
			paramMap.put("optStart", DateUtil.getdayStartDate(new Date()));
			paramMap.put("optEnd", DateUtil.getdayEndDate(new Date()));
//				modelVarService.updateTaRiskFxGrade(paramMap);
		}
	}
	
	
}
