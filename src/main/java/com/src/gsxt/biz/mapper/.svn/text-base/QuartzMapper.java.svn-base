package com.icinfo.tax.biz.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.tax.biz.dto.QuartzDto;

public interface QuartzMapper extends Mapper<QuartzDto>{

	List<QuartzDto> selectListForFPMX(Map<String,Object> qryMap);
	
	Integer selectCountForBGMX(Map<String,Object> qryMap);
	
	List<QuartzDto> selectListForZS(Map<String, Object> qryMap);
	
	List<QuartzDto> selectListForSB(Map<String, Object> qryMap);
	
	Integer initModelVar();
	
	Integer selectCountForBGModelVar(Map<String, Object> qryMap);
	Integer initTaRiskFxGrade();
}
