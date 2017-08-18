package com.icinfo.tax.biz.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.tax.biz.model.TaRiskDetail;

/**
 * 风险明细持久层接口
 * @author fanzhen
 * @date20170424
 *
 */
public interface TaRiskDetailMapper extends Mapper<TaRiskDetail>{

	/**
	 * @author fanzhen
	 * @date 20170424
	 */
	public List<TaRiskDetail> findByFxId(Map<String,Object> map);
	
	/**
	 * @author ylr
	 * @date 20170424
	 */
	public Integer updateTaRiskDetail(Map<String,Object> map);
	
	
}
