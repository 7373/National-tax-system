package com.icinfo.tax.biz.service;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.tax.biz.dto.QuartzDto;
import com.icinfo.tax.biz.dto.TaRiskDto;

public interface IQuartzService extends BaseService{

	/**
	 *获取编号
	 *@author zjj
	 *0425
	 */
	public String doGetRiskMonth(Date date) throws Exception;
	
	/**
	 * 获取发票明细数据
	 * @author zjj
	 * 
	 */
	public List<QuartzDto> selectListForFPMX(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 查询变更表数据量
	 * @author zjj
	 */
	public Integer selectCountForBGMX(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 遍历每个纳税人识别号
	 * @author zjj
	 */
	public void ergodicNsrsbh(Map<String,Object> qryMap) throws Exception;
	/**
	 * initModelVar
	 * @author ylr
	 */
	public void initModelVar() throws Exception;
	/**
	 * 查询申报表数据量
	 * @author ylr
	 */
	public Integer selectCountForBGModelVar(Map<String,Object> qryMap) throws Exception;
	/**
	 * initTaRiskFxGrade
	 * @author ylr
	 */
	public void initTaRiskFxGrade() throws Exception;
	
	
	
 }
