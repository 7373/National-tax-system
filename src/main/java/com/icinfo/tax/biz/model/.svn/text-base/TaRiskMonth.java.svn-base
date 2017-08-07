package com.icinfo.tax.biz.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

@Table(name = "TA_RISK_MONTH")
public class TaRiskMonth implements Serializable{
	
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(sys_guid(), '-', '') from dual")
	@Column(name = "MON_ID")
	public String monId;
	
	@Column(name = "RISK_MONTH")
	public String riskMonth;
	
	@Column(name = "CREATE_TIME")
	public Date createTime;


	public String getMonId() {
		return monId;
	}

	public void setMonId(String monId) {
		this.monId = monId;
	}

	public String getRiskMonth() {
		return riskMonth;
	}

	public void setRiskMonth(String riskMonth) {
		this.riskMonth = riskMonth;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "TaRiskMonth [monId=" + monId + ", riskMonth=" + riskMonth + ", createTime=" + createTime + "]";
	}
}
