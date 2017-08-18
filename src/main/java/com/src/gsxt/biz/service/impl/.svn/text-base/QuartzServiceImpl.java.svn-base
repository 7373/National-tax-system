package com.icinfo.tax.biz.service.impl;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.tax.biz.dto.QuartzDto;
import com.icinfo.tax.biz.dto.TaRiskDto;
import com.icinfo.tax.biz.mapper.QuartzMapper;
import com.icinfo.tax.biz.model.TaRisk;
import com.icinfo.tax.biz.model.TaRiskDetail;
import com.icinfo.tax.biz.service.IQuartzService;
import com.icinfo.tax.biz.service.ITaRiskDetailService;
import com.icinfo.tax.biz.service.ITaRiskService;
import com.icinfo.tax.support.DateUtil;
import com.icinfo.tax.support.UUIDUtils;

@Service
public class QuartzServiceImpl extends MyBatisServiceSupport implements IQuartzService{

	@Autowired
	QuartzMapper quartzMapper;
	@Autowired
	private ITaRiskDetailService taRiskDetailService;
	@Autowired
	private ITaRiskService taRiskService;
	
	private static final String[] arr = {"农产品收购发票或者销售发票","代扣代缴税收缴款凭证","其它扣税凭证","本期不动产允许抵扣进项税额","外贸企业进项税额抵扣证明"};
	
	/**
	 * initModelVar
	 * @author ylr
	 */
	public void initModelVar() throws Exception{
		quartzMapper.initModelVar();
	}
	/**
	 * initTaRiskFxGrade
	 * @author ylr
	 */
	public void initTaRiskFxGrade() throws Exception{
		quartzMapper.initTaRiskFxGrade();
	}
	
	
	@Override
	public String doGetRiskMonth(Date date) throws Exception {
		return DateUtil.getNmonthlater(date,-1);
	}

	@Override
	public List<QuartzDto> selectListForFPMX(Map<String, Object> qryMap) throws Exception {
		return quartzMapper.selectListForFPMX(qryMap);
	}

	@Override
	public Integer selectCountForBGMX(Map<String, Object> qryMap) throws Exception {
		return quartzMapper.selectCountForBGMX(qryMap);
	}

	@Override
	public void ergodicNsrsbh(Map<String, Object> qryMap) throws Exception {
		
		List<TaRiskDto> list =  taRiskService.doGetList(qryMap);
		if(list.size()==0){
			System.out.println("\n----------init current end---------no data");
			return;//没数据则停止
		}
		
		for(TaRiskDto riskDto : list){
			List<String> riskNameList = new ArrayList<String>();//单个nsrsbh的风险项
			if(riskDto == null || StringUtils.isBlank(riskDto.getFxId())){
				continue;
			}
			qryMap.put("nsrsbh", riskDto.getNsrsbh());
			int countAll = quartzMapper.selectListForFPMX(qryMap).size();//获取单个nsrsbh开票明细总数量
			if(countAll >25){
				/**开票份数大于25份且作废率达50%以上*/
				if(getRiskZF(qryMap,countAll))
					riskNameList.add("开票份数大于25份且作废率达50%以上");
				
				/**开票份数大于25份且红字发票50%以上*/
				if(getRiskHZ(qryMap,countAll))
					riskNameList.add("开票份数大于25份且红字发票50%以上");
				
				/**发票份额大于25份且顶额开具50%以上 */
				if(getRiskGF(qryMap,countAll))
					riskNameList.add("发票份额大于25份且顶额开具50%以上");
			}
			
			/**企业变更后集中开票 */
			if(getRiskBG(qryMap)){
				riskNameList.add("企业变更后集中开票");
			}
			
			/**应纳税减征额填报金额较大*/
			List<QuartzDto> zsList = quartzMapper.selectListForZS(qryMap);
			if(zsList.size()>0)
				riskNameList.add("应纳税减征额填报金额较大:"+zsList.get(0).getJe());	
			
			/**申报表第6栏有数值*/
			/**申报表第7栏有数值*/
			/**申报表第8栏有数值*/
			/**申报表第10栏有数值*/
			/**申报表第11栏有数值*/
			riskNameList = getRiskSB(qryMap,riskNameList);
			
			//所有风险项插入detail表
			TaRiskDetail detail = new TaRiskDetail();
			detail.setFxId(riskDto.getFxId());
			for(String str : riskNameList){
				detail.setRiskMonth(this.doGetRiskMonth((Date)qryMap.get("date")));
				detail.setId(UUIDUtils.randomUUID());
				detail.setRiskName(str);
				taRiskDetailService.insert(detail);
			}
			//更新risk表的风险项数
			TaRisk risk = new TaRisk();
			risk.setFxId(riskDto.getFxId());
			risk.setRiskNum(String.valueOf(riskNameList.size()));
			taRiskService.update(risk);
		}
	}
	
	/**获取是否有风险项（作废率达50%以上且开票份数大于25份）
	 * @author zjj
	 */
	 public boolean getRiskZF(Map<String,Object> qryMap,int countAll)throws Exception{
		qryMap.put("zfbz", "Y");
		int countOne = quartzMapper.selectListForFPMX(qryMap).size();
		if(((double)countOne/(double)countAll)>0.5){
			return true;
		}
		return false;
	 }
	 
	 /**获取是否有风险项（红字发票50%以上且开票份数大于25份）
	 * @author zjj
	 */
	public boolean getRiskHZ(Map<String,Object> qryMap,int countAll)throws Exception{
		qryMap.put("jeX",0);
		int countTwo = quartzMapper.selectListForFPMX(qryMap).size();
		if(((double)countTwo/(double)countAll)>0.5){
			return true;
		}
		return false;
	}
	
	/**获取是否有风险项（顶额开具50%以上且发票份额大于25份）
	 * @author zjj
	 */
	public boolean getRiskGF(Map<String,Object> qryMap,int countAll) throws Exception{
		qryMap.put("jeD", 95000);
		List<QuartzDto> quartList =quartzMapper.selectListForFPMX(qryMap);
		int countTre = 0;
		for(QuartzDto quart : quartList ){
			//是否以9开头
			if(String.valueOf(quart.getJe()).startsWith("9"))
				countTre++;
		}
		if(((double)countTre/(double)countAll)>0.5){
			return true;
		}
		return false;
	}
	/**
	 * 获取是否有变更信息
	 * @author zjj
	 */
	public boolean getRiskBG(Map<String,Object> qryMap) throws Exception{
		List<QuartzDto> quartList = null;
		qryMap.put("lrrqStart",DateUtil.getLastDayForMonth(DateUtil.getMonth((Date)qryMap.get("date"),-3)));
		qryMap.put("lrrqEnd",DateUtil.getFirstDayForMonth(DateUtil.getMonth((Date)qryMap.get("date"),-1)));
		if(quartzMapper.selectCountForBGMX(qryMap)>0){//前月有数值
			qryMap.put("dateStart",DateUtil.getLastDayForMonth(DateUtil.getMonth((Date)qryMap.get("date"),-3)));
			qryMap.put("dateEnd",DateUtil.getFirstDayForMonth(DateUtil.getMonth((Date)qryMap.get("date"),-1)));
			quartList =quartzMapper.selectListForFPMX(qryMap);
			if(quartList.size()>25) return true;
			qryMap.put("dateStart",DateUtil.getLastDayForMonth(DateUtil.getMonth((Date)qryMap.get("date"),-2)));
			qryMap.put("dateEnd", DateUtil.getFirstDayForMonth(DateUtil.getMonth((Date)qryMap.get("date"),0)));
			quartList =quartzMapper.selectListForFPMX(qryMap);
			if(quartList.size()>25) return true;
		}
		qryMap.put("lrrqStart",DateUtil.getLastDayForMonth(DateUtil.getMonth((Date)qryMap.get("date"),-2)));
		qryMap.put("lrrqEnd",DateUtil.getFirstDayForMonth(DateUtil.getMonth((Date)qryMap.get("date"),0)));
		if(quartzMapper.selectCountForBGMX(qryMap)>0){//当月月有数值
			qryMap.put("dateStart",DateUtil.getLastDayForMonth(DateUtil.getMonth((Date)qryMap.get("date"),-2)));
			qryMap.put("dateEnd",DateUtil.getFirstDayForMonth(DateUtil.getMonth((Date)qryMap.get("date"),0)));
			quartList =quartzMapper.selectListForFPMX(qryMap);
			if(quartList.size()>25) return true;
		}
		return false;
	}
	/**
	 * 计算是否有申报表信息
	 * @author zjj
	 */
	public List<String> getRiskSB(Map<String,Object> qryMap,List<String> riskNameList) throws Exception{
		List<QuartzDto> list =null;
		/**申报表第6栏有数值*/
		/**申报表第7栏有数值*/
		/**申报表第8栏有数值*/
		/**申报表第10栏有数值*/
		/**申报表第11栏有数值*/
		for(String str : arr){
			qryMap.put("hmc", str);
			list = quartzMapper.selectListForSB(qryMap);
			if(list.size()>0)
				riskNameList.add(str+":"+list.get(0).getJe());
		}
		
		return riskNameList;
	}
	/**
	 * 查询申报表数据量
	 * @author ylr
	 */
	public Integer selectCountForBGModelVar(Map<String,Object> qryMap) throws Exception{
		return quartzMapper.selectCountForBGModelVar(qryMap);
	}
}



















