package com.icinfo.tax.biz.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.tax.biz.model.TaEntMaintain;

public interface ITaEntMaintainService extends BaseService{

	/**
	 * 保存维护的企业信息
	 * @author zjj
	 * 20170525
	 * @param taEntMaintain
	 * @return
	 * @throws Exception
	 */
	public int insert(TaEntMaintain taEntMaintain) throws Exception;
	
	/**
	 * 获取维护的企业信息列表
	 * @author ylr
	 * 20170525
	 * @return
	 * @throws Exception
	 */
	public List<TaEntMaintain> queryPage(PageRequest request) throws Exception;
}
