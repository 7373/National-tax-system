package com.icinfo.tax.biz.mapper;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.tax.biz.dto.QuartzDto;
import com.icinfo.tax.biz.model.DmCzry;

public interface DmCzryMapper extends Mapper<QuartzDto>{

	DmCzry doSelectUserInfo(String userid);
	
}
