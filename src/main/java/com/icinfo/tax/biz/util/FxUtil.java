package com.icinfo.tax.biz.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.icinfo.tax.biz.dto.TaRiskDto;

public class FxUtil {

	/**
	 * 将taRiskDto实体类的属性封装到map中
	 * @author fanzhen
	 * @date 20170503
	 * @param riskDto
	 * @return
	 */
	public static Map<String,Object> toMap(TaRiskDto riskDto){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("entName", riskDto.getEntName());
    	map.put("buildDateLeft", transDateToStr(riskDto.getBuildDateLeft()));
    	map.put("buildDateRight", transDateToStr(riskDto.getBuildDateRight()));
    	map.put("industry", riskDto.getIndustry());
    	map.put("nsrsbh", riskDto.getNsrsbh());
    	map.put("regisAddr", riskDto.getRegisAddr());
    	map.put("businessScope", riskDto.getBusinessScope());
    	map.put("legalPerson", riskDto.getLegalPerson());
    	map.put("financePerson", riskDto.getFinancePerson());
    	map.put("fxGradeLeft", riskDto.getFxGradeLeft());
    	map.put("fxGradeRight", riskDto.getFxGradeRight());
    	map.put("examStatus", riskDto.getExamStatus());
    	map.put("examDateLeft", transDateToStr(riskDto.getExamDateLeft()));
    	map.put("examDateRight", transDateToStr(riskDto.getExamDateRight()));
    	map.put("examPeople", riskDto.getExamPeople());
    	map.put("identityStatus", riskDto.getIdentityStatus());
    	map.put("managerDepart", riskDto.getManagerDepart());
    	map.put("riskName", riskDto.getRiskName());
    	map.put("riskMonth", riskDto.getRiskMonth());
    	map.put("riskType", riskDto.getRiskType());
    	map.put("riskNumLeft", riskDto.getRiskNumLeft());
    	map.put("riskNumRight", riskDto.getRiskNumRight());
    	return map;
	}
	
	public static String transDateToStr(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		if(date==null){
			return null;
		}
		return sdf.format(date);
	}
	
	/**
	 * 转换风险项的名称(防止导出的时候乱码)
	 * @author fanzhen
	 * @date 20170503
	 * @param src
	 * @return
	 */
	public static String transRiskName(String src){
		String str = "";
		if(src==null){
			return str;
		}
		switch(src){
		case "1003": 
			str= "开票份数大于25份且作废率达50%以上";
			break;
		case "1004":
			str = "开票份数大于25份且红字发票50%以上";
			break;
		case "1005":
			str = "发票份额大于25份且顶额开具50%以上";
			break;
		case "1007":
			str = "企业变更后集中开票";
			break;
		case "1008":
			str = "应纳税减征额填报金额较大";
			break;
		case "1009":
			str = "农产品收购发票或者销售发票";
			break;
		case "1010":
			str = "代扣代缴税收缴款凭证";
			break;
		case "1011":
			str = "其它扣税凭证";
			break;
		case "1012":
			str = "期不动产允许抵扣进项税额";
			break;
		case "1013":
			str = "外贸企业进项税额抵扣证明";
			break;
		default:
			str = "";
			break;
		}
		return str;
	}
	
}
