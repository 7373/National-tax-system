package com.icinfo.tax.biz.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.tax.biz.dto.TaRiskDto;
import com.icinfo.tax.biz.model.TaRisk;

public interface TaRiskMapper extends Mapper<TaRisk> {

	public List<TaRiskDto> selectTaRiskList(Map<String,Object> qryMap);
	
	public List<TaRiskDto> selectQueryProcessList(Map<String,Object> qryMap);
	public List<TaRiskDto> selectQueryProcessListForAdvance(Map<String,Object> qryMap);
	public List<TaRiskDto> selectQueryProcessListForCurrent(Map<String,Object> qryMap);
	
	/**
	 * 通过风险id  fxId来查找风险详情
	 * @author fanzhen
	 * @date 20170424
	 * @param fxId
	 * @return
	 */
	public List<TaRiskDto> selectRiskDetail(String fxId);
	
	public void insertList(Map<String,Object> qryMap);
	
	public List<TaRiskDto> selectRiskList(Map<String,Object> qryMap);
	
	/**
	 * 查看风险
	 * 预警待处理
	 * @author ylr
	 * @date 20170425
	 */
	public List<TaRiskDto> selectWarnProcessList(Map<String,Object> qryMap);
	public List<TaRiskDto> selectWarnProcessListForAdvance(Map<String,Object> qryMap);
	public List<TaRiskDto> selectWarnProcessListForCurrent(Map<String,Object> qryMap);
	
	/**
	 * 查看待核查的风险(包括已核查和未核查)
	 * @author fanzhen
	 * @date 20170425
	 * @return
	 */
	public Map<String,Integer> countRisk();
	
	/**
	 * 人员工作量统计
	 * @author fanzhen
	 * @date 20170425
	 * @param dto
	 * @return
	 */
	public List<TaRiskDto> searchPeopleWorkCount(TaRiskDto dto);
	/**
	 * 处理结果统计
	 * @author fanzhen
	 * @date 20170426
	 * @param dto
	 * @return
	 */
	public Map<String,Object> searchResultCount(TaRiskDto dto);
	
	/**
	 *gengxin
	 * @author ylr
	 * @date 20170426
	 * @param dto
	 * @return
	 */
	public Integer updateTaRisk(Map<String,Object> map);
	/**
	 * 获取modeltorisklist
	 * @author ylr
	 * @date 20170425
	 */
	public List<TaRiskDto> selectModelToRiskList(Map<String,Object> qryMap);
	/**
	 *批量插入list
	 * @author ylr
	 * @date 20170426
	 * @param dto
	 * @return
	 */
	public Integer doBatchInsertTaRisk(List<TaRiskDto> list);
	
	
	
	void insertForBaseInfo(Map<String,Object> map);
	/**
	 *去除重复数据
	 * @author ylr
	 * @date 20170509
	 * @param dto
	 * @return
	 */
	public Integer doDeleteNsrsbhRepeat();
	public Integer deleteTaRiskAdvance();
//	事前风险算分结束后，初始化事前风险强度、与事前风险详细
	public Integer insertAdvance1();
	public Integer insertAdvance2();
	public Integer updateAdvanceRiskNum();
	public Integer updateAdvanceIdentityStatus();
	
	public Integer countTaRisk(Map<String, Object> qryMap);
	
	public int deleteMaintainEnt();
	
	
}
