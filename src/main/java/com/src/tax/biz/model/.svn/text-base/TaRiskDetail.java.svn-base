package com.icinfo.tax.biz.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 风险明细实体类
 * @author fanzhen
 * @date20170424
 */
@Table(name = "TA_RISK_DETAIL")
public class TaRiskDetail implements Serializable{

	private static final long serialVersionUID = -6453819922525492955L;
	/**
     * 主键
     */
    @Id
    @Column(name = "ID")
	private String id;
    @Column(name = "FXID")
	private String fxId;
    //预警点
	@Column(name="RISK_NAME")
	private String riskName;
	@Column(name="EXAMRESULT")
	//核查结果
	private String examResult;
	@Column(name="RISK_MONTH")
	//产生风险日期
	private String riskMonth;
	//核查日期
	@Column(name="EXAMDATE")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date examDate;
	//企业名称
	private String entName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFxId() {
		return fxId;
	}
	public void setFxId(String fxId) {
		this.fxId = fxId;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	public String getExamResult() {
		return examResult;
	}
	public void setExamResult(String examResult) {
		this.examResult = examResult;
	}
	
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
	public String getRiskMonth() {
		return riskMonth;
	}
	public void setRiskMonth(String riskMonth) {
		this.riskMonth = riskMonth;
	}
	public String toString() {
		return "TaRiskDetail [id=" + id + ", fxId=" + fxId + ", riskName=" + riskName + ", examResult=" + examResult
				+ "]";
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
}
