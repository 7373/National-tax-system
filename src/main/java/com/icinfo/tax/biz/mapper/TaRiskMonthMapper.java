package com.icinfo.tax.biz.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.tax.biz.model.TaRiskMonth;

public interface TaRiskMonthMapper extends Mapper<TaRiskMonth>{
	/**
	 * 查询表中所有的信息
	 * fanzhen
	 * 20170425
	 * @return
	 */
	public List<TaRiskMonth> findTaRiskMonthList(Map<String,Object> qryMap);
	
}
