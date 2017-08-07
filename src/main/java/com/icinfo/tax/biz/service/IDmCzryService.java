package com.icinfo.tax.biz.service;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.tax.biz.model.DmCzry;

public interface IDmCzryService extends BaseService{

	/**
	 *获取用户信息
	 *@author ylr
	 *0425
	 */
	public DmCzry doSelectUserInfo(String userid) throws Exception;
	

	
	
	
 }
