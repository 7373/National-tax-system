package com.icinfo.tax.biz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.tax.biz.mapper.ModelVarMapper;
import com.icinfo.tax.biz.model.ModelVar;
import com.icinfo.tax.biz.service.IModelVarService;
@Service
public class ModelVarServiceImpl extends MyBatisServiceSupport implements IModelVarService {

	@Autowired
	private ModelVarMapper modelVarMapper; 
	
	/**
	 * 获取明细数据
	 * @author ylr
	 * 
	 */
	public List<ModelVar> getModelVarList(Map<String,Object> qryMap) throws Exception{
		PageHelper.startPage(Integer.parseInt(qryMap.get("skipResult").toString()),Integer.parseInt(qryMap.get("pageSize").toString()));
		return modelVarMapper.getModelVarList(qryMap);
	}
	
	/**
	 * 删除数据
	 * @author ylr
	 * 
	 */
	public Integer deleteModelVarByNsrsbh(List<ModelVar> modelVarList) throws Exception{
		return modelVarMapper.deleteModelVarByNsrsbh(modelVarList);
	}
	
	/**
	 * 插入增量数据
	 * @author ylr
	 * 
	 */
	public Integer insertIncrementModelVar(Map<String,Object> qryMap) throws Exception{
		return modelVarMapper.insertIncrementModelVar(qryMap);
	}
	/**
	 * 统计增量数据
	 * @author ylr
	 * 
	 */
	public Integer selectCountForModelVar(Map<String,Object> qryMap) throws Exception{
		return modelVarMapper.selectCountForModelVar(qryMap);
	}
	/**
	 * 更新事前风险分数
	 * @author ylr
	 * 
	 */
	public Integer updateTaRiskFxGrade(Map<String,Object> qryMap) throws Exception{
		return modelVarMapper.updateTaRiskFxGrade(qryMap);
	}
	/**
	 * 获取明细数据
	 * @author ylr
	 * 
	 */
	public List<ModelVar> selectNsrsbhList() throws Exception{
		return modelVarMapper.selectNsrsbhList();
	}
	/**
	 * 初始化事前风险
	 * @author ylr
	 * 
	 */
	public Integer initAdvanceTaRisk() throws Exception{
		return modelVarMapper.initAdvanceTaRisk();
	}
	/**
	 * 清空modelvar
	 * @author ylr
	 * 
	 */
	public Integer deleteAllModelVar() throws Exception{
		return modelVarMapper.deleteAllModelVar();
	}
	
	/**
	 * 初始modelvar
	 * @author ylr
	 * 
	 */
	public Integer doInitModelVar() throws Exception{
		return modelVarMapper.doInitModelVar();
	}
	
	/**
	 * 计算事前风险点
	 * @author ylr
	 * 
	 */
	public Integer doInitFxStatusDetail() throws Exception{
		return modelVarMapper.doInitFxStatusDetail();
	}
}
