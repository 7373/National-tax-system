package com.icinfo.tax.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.tax.biz.mapper.TaEntMaintainMapper;
import com.icinfo.tax.biz.model.TaEntMaintain;
import com.icinfo.tax.biz.service.ITaEntMaintainService;
import com.icinfo.tax.support.UUIDUtils;
@Service
public class TaEntMaintainServiceImpl extends MyBatisServiceSupport implements ITaEntMaintainService{

	@Autowired
	TaEntMaintainMapper taEntMaintainMapper;
	
	@Override
	public int insert(TaEntMaintain taEntMaintain) throws Exception {
		taEntMaintain.setId(UUIDUtils.randomUUID());
		return taEntMaintainMapper.insertSelective(taEntMaintain);
	}
	
	/**
	 * 获取维护的企业信息列表
	 * @author ylr
	 * 20170525
	 * @return
	 * @throws Exception
	 */
	public List<TaEntMaintain> queryPage(PageRequest request) throws Exception{
		 PageHelper.startPage(request.getPageNum(), request.getLength());
	        return taEntMaintainMapper.selectEntMaintainList();
	}

}
