package com.icinfo.tax.biz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.tax.biz.mapper.TaRiskMonthMapper;
import com.icinfo.tax.biz.model.TaRiskMonth;
import com.icinfo.tax.biz.service.ITaRiskMonthService;

@Service
public class TaRiskMonthServiceImpl extends MyBatisServiceSupport implements ITaRiskMonthService {

	@Autowired
	TaRiskMonthMapper taRiskMonthMapper;
	
	public void insert(TaRiskMonth taRiskMonth) throws Exception{
		taRiskMonthMapper.insert(taRiskMonth);
	}
	/**
	 * @author fanzhen
	 * @date20170425
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TaRiskMonth> findTaRiskMonthList(Map<String,Object> qryMap) throws Exception {
		List<TaRiskMonth> list = taRiskMonthMapper.findTaRiskMonthList(qryMap);
		return list;
	}
}
