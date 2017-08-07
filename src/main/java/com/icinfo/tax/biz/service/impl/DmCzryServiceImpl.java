package com.icinfo.tax.biz.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.tax.biz.mapper.DmCzryMapper;
import com.icinfo.tax.biz.model.DmCzry;
import com.icinfo.tax.biz.service.IDmCzryService;

@Service
public class DmCzryServiceImpl extends MyBatisServiceSupport implements IDmCzryService{

	@Autowired
	DmCzryMapper dmCzryMapper;
	/**
	 *获取用户信息
	 *@author ylr
	 *0425
	 */
	public DmCzry doSelectUserInfo(String userid) throws Exception{
		return dmCzryMapper.doSelectUserInfo(userid);
	}
}



















