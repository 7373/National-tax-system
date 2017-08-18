package com.icinfo.tax.biz.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.tax.biz.dto.TaRiskDto;
import com.icinfo.tax.biz.model.TaRisk;

public interface ITaRiskService extends BaseService{
	/**
	 *获取事前风险
	 *@author zjj
	 *20170421
	 */
	List<TaRiskDto> queryPage(PageRequest request) throws Exception;
	
	
	/**
	 *获取事前风险
	 *@author ylr
	 *20170424
	 */
	List<TaRiskDto> doGetQueryProcessList(PageRequest request) throws Exception;
	
	/**
	 * 插入数据
	 */
	public void insertForBaseInfo(Map<String,Object> qryMap)throws Exception;
	/**
	 * 获取数据
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<TaRiskDto> doGetList(Map<String,Object> qryMap)throws Exception;
	/**
	 *获取事前风险
	 *@author ylr
	 *20170424
	 */
	List<TaRiskDto> doGetWarnProcessList(PageRequest request) throws Exception;
	/**
	 * 更新数据
	 */
	public void update(TaRisk risk)throws Exception;
	/**
	 * 生成Excel并下载
	 * fanzhen
	 * 20170425
	 * @param list
	 * @return
	 */
//	public String downloadExtFile(List<TaRiskDto> list,HttpServletRequest req,HttpServletResponse response) throws Exception;
	/**
	 * 查看风险(包括已核查和未核查)
	 * @author fanzhen
	 * @date20170425
	 * @return
	 */
	public Map<String,Integer> countRisk() throws Exception;
	
	/**
	 * 人员工作量统计
	 * @author fanzhen
	 * @date20170426
	 * @param dto
	 * @return
	 */
	public List<TaRiskDto> searchPeopleWorkCount(TaRiskDto dto) throws Exception;
	
	/**
	 * 处理结果统计
	 * @author fanzhen
	 * @date20170426
	 * @param dto
	 * @return
	 */
	public Map<String,Object> searchResultCount(TaRiskDto dto) throws Exception;
	
	/**
	 * 更新数据
	 * @author ylr
	 * @date20170426
	 * @param dto
	 * @return
	 */
	public Integer updateTaRisk(Map<String,Object> map) throws Exception;
	
	
	/**
	 * 删除所有无风险项的数据
	 * @author zjj
	 */
	public void deleteRiskNum() throws Exception;
	
	/**
	 * 通过dto查找所有的风险数据
	 * @author fanzhen
	 * @data 20170428
	 */
	List<TaRiskDto> selectTaRiskListByDto(Map<String,Object> map) throws Exception; 
	
	/**
	 * 获取modeltorisk
	 * @author ylr
	 * @data 20170428
	 */
	List<TaRiskDto> selectModelToRiskList(Map<String,Object> map) throws Exception; 
	/**
	 * 批量插入
	 * @author ylr
	 * @data 20170428
	 */
	Integer doBatchInsertTaRisk(List<TaRiskDto> list) throws Exception; 
	/**
	 * 剔除重复数据
	 * @author ylr
	 * @data 20170428
	 */
	Integer doDeleteNsrsbhRepeat() throws Exception; 
	/**
	 * 剔除事前风险
	 * @author ylr
	 * @data 20170428
	 */
	Integer deleteTaRiskAdvance() throws Exception; 
	
	/**
	 * 事前风险4个初始化
	 * @author ylr
	 * @data 20170517
	 */
	void initTaRiskAdvance() throws Exception; 
	/**
	 * 构建事中风险返回list
	 * @author ylr
	 * @data 20170523
	 */
	List<TaRiskDto> doBuildCurrentList(List<TaRiskDto> list) throws Exception;
	/**
	 * 删除所有排除风险企业
	 * @author zjj
	 * 20170525
	 */
	public int deleteMaintainEnt() throws Exception;
	
	
}
