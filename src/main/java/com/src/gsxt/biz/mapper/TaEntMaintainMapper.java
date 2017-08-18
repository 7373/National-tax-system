package com.icinfo.tax.biz.mapper;

import java.util.List;
import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.tax.biz.model.TaEntMaintain;

public interface TaEntMaintainMapper extends Mapper<TaEntMaintain>{
	
	List<TaEntMaintain> selectEntMaintainList();

}
