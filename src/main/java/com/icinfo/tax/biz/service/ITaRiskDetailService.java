package com.icinfo.tax.biz.service;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.tax.biz.model.TaRiskDetail;

/**
 * 风险明细业务层接口
 * @author fanzhen
 * @date20170424
 */
public interface ITaRiskDetailService extends BaseService{

	/**
	 * 根据风险Id查找风险明细
	 * @param fxId
	 * @return
	 * @throws Exception
	 */
	public List<TaRiskDetail> findByFxId(Map<String,Object> map) throws Exception;
	
	/**
	 * 根据Id更新数据
	 * @return
	 * @throws Exception
	 */
	public Integer updateTaRiskDetail(Map<String,Object> map) throws Exception;
	
	
	/**
	 * 插入数据
	 * @author zjj
	 */
	public void insert(TaRiskDetail detail) throws Exception;
}
