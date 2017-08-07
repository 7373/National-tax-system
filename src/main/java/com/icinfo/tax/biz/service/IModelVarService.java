package com.icinfo.tax.biz.service;
import java.util.List;
import java.util.Map;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.tax.biz.model.ModelVar;


public interface IModelVarService extends BaseService{
	
	/**
	 * 获取明细数据
	 * @author ylr
	 * 
	 */
	public List<ModelVar> getModelVarList(Map<String,Object> qryMap) throws Exception;
	/**
	 * 删除数据
	 * @author ylr
	 * 
	 */
	public Integer deleteModelVarByNsrsbh(List<ModelVar> modelVarList) throws Exception;
	
	/**
	 * 插入增量数据
	 * @author ylr
	 * 
	 */
	public Integer insertIncrementModelVar(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 统计增量数据
	 * @author ylr
	 * 
	 */
	public Integer selectCountForModelVar(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 更新事前风险分数
	 * @author ylr
	 * 
	 */
	public Integer updateTaRiskFxGrade(Map<String,Object> qryMap) throws Exception;
	/**
	 * 获取明细数据
	 * @author ylr
	 * 
	 */
	public List<ModelVar> selectNsrsbhList() throws Exception;
	/**
	 * 初始化事前风险
	 * @author ylr
	 * 
	 */
	public Integer initAdvanceTaRisk() throws Exception;
	/**
	 * 清空modelvar
	 * @author ylr
	 * 
	 */
	public Integer deleteAllModelVar() throws Exception;
	/**
	 * 初始modelvar
	 * @author ylr
	 * 
	 */
	public Integer doInitModelVar() throws Exception;
	/**
	 * 计算事前风险点
	 * @author ylr
	 * 
	 */
	public Integer doInitFxStatusDetail() throws Exception;
	
	
	
	
	
	

}
