package com.icinfo.tax.biz.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.tax.biz.model.ModelVar;

public interface ModelVarMapper extends Mapper<ModelVar> {
	
	List<ModelVar> getModelVarList(Map<String, Object> map);
	
	Integer deleteModelVarByNsrsbh(List<ModelVar> modelVarList);
	Integer insertIncrementModelVar(Map<String, Object> map);
	Integer selectCountForModelVar(Map<String, Object> map);
	Integer updateTaRiskFxGrade(Map<String, Object> map);
	List<ModelVar> selectNsrsbhList();
	
	Integer initAdvanceTaRisk();
	Integer deleteAllModelVar();
	Integer doInitModelVar();
	Integer doInitFxStatusDetail();
	

}
