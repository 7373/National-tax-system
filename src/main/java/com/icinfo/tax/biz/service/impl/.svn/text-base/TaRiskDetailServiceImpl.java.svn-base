package com.icinfo.tax.biz.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.tax.biz.mapper.TaRiskDetailMapper;
import com.icinfo.tax.biz.model.TaRiskDetail;
import com.icinfo.tax.biz.service.ITaRiskDetailService;

/**
 * 风险明细业务层接口
 * @author fanzhen
 * @date20170424
 */
@Service("taRiskDetailService")
public class TaRiskDetailServiceImpl extends MyBatisServiceSupport implements ITaRiskDetailService{

	@Resource(name="taRiskDetailMapper")
	private TaRiskDetailMapper taRiskDetailMapper;

	/**
	 * 根据风险Id查找风险明细
	 * @param fxId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TaRiskDetail> findByFxId(Map<String,Object> map) throws Exception {
		List<TaRiskDetail> list = taRiskDetailMapper.findByFxId(map);
		return list;
	}
	
	/**
	 * 根据Id更新数据
	 * @return
	 * @throws Exception
	 */
	public Integer updateTaRiskDetail(Map<String,Object> map) throws Exception{
		return taRiskDetailMapper.updateTaRiskDetail(map);
	}

	@Override
	public void insert(TaRiskDetail detail) throws Exception {
		taRiskDetailMapper.insertSelective(detail);
	}
}



















