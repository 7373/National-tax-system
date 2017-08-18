package com.icinfo.tax.biz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.tax.biz.dto.TaRiskDto;
import com.icinfo.tax.biz.mapper.TaRiskMapper;
import com.icinfo.tax.biz.model.TaRisk;
import com.icinfo.tax.biz.service.ITaRiskService;
import com.icinfo.tax.biz.util.FxUtil;
@Service("taRiskService")
public class TaRiskServiceImpl extends MyBatisServiceSupport  implements ITaRiskService {

	@Autowired
	private TaRiskMapper taRiskMapper;

	@Value("${fileExtractPath}")
	private String fileExtractPath;
	
	@Override
	public List<TaRiskDto> queryPage(PageRequest request) throws Exception {
        Map<String,Object> map = request.getParams();
        if(map.get("industry")!=null && !map.get("industry").equals("")){
        	String obj = (String)map.get("industry");
            String[] strs = obj.split(",");
            map.put("industry", strs);
        }
        map.put("riskName", FxUtil.transRiskName(map.get("riskName")+""));
        
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return taRiskMapper.selectTaRiskList(map);
	}
	
	@Override
	public List<TaRiskDto> doGetQueryProcessList(PageRequest request) throws Exception {
		Map<String, Object> qryMap = request.getParams();
		PageHelper.startPage(request.getPageNum(), request.getLength());
		if("ADVANCE".equals(qryMap.get("riskType").toString())){
			return taRiskMapper.selectQueryProcessListForAdvance(qryMap);
		}
		if("CURRENT".equals(qryMap.get("riskType").toString())||StringUtils.isNotBlank(qryMap.get("riskMonth").toString())){
			return taRiskMapper.selectQueryProcessListForCurrent(qryMap);
		}
        return taRiskMapper.selectQueryProcessList(request.getParams());
	}

	@Override
	public void insertForBaseInfo(Map<String, Object> qryMap) throws Exception {
		taRiskMapper.insertForBaseInfo(qryMap);
	}

	@Override
	public List<TaRiskDto> doGetList(Map<String, Object> qryMap) throws Exception {
		return taRiskMapper.selectRiskList(qryMap);
	}

	@Override
	public void update(TaRisk risk) throws Exception {
		taRiskMapper.updateByPrimaryKeySelective(risk);
	}
	
	/**
	 *获取事前风险
	 *@author ylr
	 *20170424
	 */
	public List<TaRiskDto> doGetWarnProcessList(PageRequest request) throws Exception{
		Map<String, Object> qryMap = request.getParams();
		PageHelper.startPage(request.getPageNum(), request.getLength());
		if("ADVANCE".equals(qryMap.get("riskType").toString())){
			return taRiskMapper.selectWarnProcessListForAdvance(qryMap);
		}
		if("CURRENT".equals(qryMap.get("riskType").toString())||StringUtils.isNotBlank(qryMap.get("riskMonth").toString())){
			return taRiskMapper.selectWarnProcessListForCurrent(qryMap);
		}
        return taRiskMapper.selectWarnProcessList(request.getParams());
	}

	/**
	 * 人员工作量统计
	 * @author fanzhen
	 * @date20170426
	 * @param dto
	 * @return
	 */
	@Override
	public List<TaRiskDto> searchPeopleWorkCount(TaRiskDto dto) throws Exception{
		List<TaRiskDto> list = taRiskMapper.searchPeopleWorkCount(dto);
		return list;
	}
	/**
	 * 处理结果统计
	 * @author fanzhen
	 * @date20170426
	 * @param dto
	 * @return
	 */
	@Override
	public Map<String, Object> searchResultCount(TaRiskDto dto) throws Exception {
		Map<String,Object> map = taRiskMapper.searchResultCount(dto);
		return map;
	}

	/**
	 * 查看风险(包括已核查和未核查)
	 * @author fanzhen
	 * @date20170425
	 * @return
	 */
	@Override
	public Map<String, Integer> countRisk() throws Exception {
		Map<String,Integer> map = taRiskMapper.countRisk();
		return map;
	}
	
	/**
	 * 更新数据
	 * @author ylr
	 * @date20170426
	 * @param dto
	 * @return
	 */
	public Integer updateTaRisk(Map<String,Object> map) throws Exception{
		return taRiskMapper.updateTaRisk(map);
	}

	@Override
	public void deleteRiskNum() throws Exception {
		Example example = new Example(TaRisk.class);
        example.createCriteria().andEqualTo("riskNum","0").andEqualTo("riskType","CURRENT");	
        taRiskMapper.deleteByExample(example);
	}

	/**
	 * 通过dto查找所有的风险数据
	 * @author fanzhen
	 * @data 20170428
	 */
	@Override
	public List<TaRiskDto> selectTaRiskListByDto(Map<String,Object> map) throws Exception {
		if(map.get("industry")!=null && !map.get("industry").equals("")){
        	String obj = (String)map.get("industry");
            String[] strs = obj.split(",");
            map.put("industry", strs);
        }
		return taRiskMapper.selectTaRiskList(map);
	}
	
	/**
	 * 获取modeltorisk
	 * @author ylr
	 * @data 20170428
	 */
	public List<TaRiskDto> selectModelToRiskList(Map<String,Object> map) throws Exception{
		return taRiskMapper.selectModelToRiskList(map);
	}
	/**
	 * 批量插入
	 * @author ylr
	 * @data 20170428
	 */
	public Integer doBatchInsertTaRisk(List<TaRiskDto> list) throws Exception{
		return taRiskMapper.doBatchInsertTaRisk(list);
	}
	/**
	 * 剔除重复数据
	 * @author ylr
	 * @data 20170428
	 */
	public Integer doDeleteNsrsbhRepeat() throws Exception{
		return taRiskMapper.doDeleteNsrsbhRepeat();
	}
	/**
	 * 剔除事前风险
	 * @author ylr
	 * @data 20170428
	 */
	public Integer deleteTaRiskAdvance() throws Exception{
		return taRiskMapper.deleteTaRiskAdvance();
	}
	/**
	 * 事前风险4个初始化
	 * @author ylr
	 * @data 20170517
	 */
	public void initTaRiskAdvance() throws Exception{
		taRiskMapper.insertAdvance1();
		taRiskMapper.insertAdvance2();
		taRiskMapper.updateAdvanceRiskNum();
		taRiskMapper.updateAdvanceIdentityStatus();
	}
	/**
	 * 构建事中风险返回list
	 * @author ylr
	 * @data 20170523
	 */
	public List<TaRiskDto> doBuildCurrentList(List<TaRiskDto> list) throws Exception{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("riskType", "ADVANCE");
		for(TaRiskDto dto:list){
			qryMap.put("nsrsbh", dto.getNsrsbh());
			dto.setRiskSign("0");
			if(taRiskMapper.countTaRisk(qryMap)>0)
				dto.setRiskSign("1");
		}
		return list;
	}

	@Override
	public int deleteMaintainEnt() throws Exception {
		return taRiskMapper.deleteMaintainEnt();
	}
}
