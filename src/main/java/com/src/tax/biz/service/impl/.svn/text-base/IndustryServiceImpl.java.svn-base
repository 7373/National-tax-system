package com.icinfo.tax.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.tax.biz.mapper.IndustryMapper;
import com.icinfo.tax.biz.model.Industry;
import com.icinfo.tax.biz.service.IIndustryService;

@Service("industryService")
public class IndustryServiceImpl extends MyBatisServiceSupport implements IIndustryService{
	
	@Resource(name="industryMapper")
	private IndustryMapper industryMapper;
	/**
	 * 查询所有的行业(一类与二类)
	 * @author fanzhen
	 * @date 20170502
	 * @return
	 * @throws Exception
	 */
	public List<Industry> findAllIndustry() throws Exception {
		List<Industry> list = industryMapper.findAllIndustry();
		return list;
	}
	
}
