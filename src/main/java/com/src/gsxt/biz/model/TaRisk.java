package com.icinfo.tax.biz.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Table(name = "TA_RISK")
public class TaRisk implements Serializable{

	private static final long serialVersionUID = -3764089176373877585L;

	/**
     * 主键
     */
    @Id
    @Column(name = "FXID")
    private String fxId;
	//纳税人识别号
    @Column(name = "NSRSBH")
    private String nsrsbh;
    //风险评分
    @Column(name = "FXGRADE")
    private  String fxGrade;
    @Column(name="IDENTITYSTATUS")
    //算法认定状态
    private String identityStatus;
    //风险类型
    @Column(name = "RISKTYPE")
    private String riskType;
    //风险项
    @Column(name = "RISKNUM")
    private String riskNum;
    //核查状态
    @Column(name = "EXAMSTATUS")
    private String examStatus;
    //核查人
    @Column(name = "EXAMPEOPLE")
    private String examPeople;
    //核查日期
    @Column(name = "EXAMDATE")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date examDate;
    //核查日期的年月份
    @Column(name = "RISK_MONTH")
    private String riskMonth;
    //核查人管理科室
    @Column(name="ZGSWSKFJ_DM")
    private String examManagerDepart;
    @Column(name="TAX_AMOUNT")
    private String taxAmount;
	public String getFxId() {
		return fxId;
	}

	public void setFxId(String fxId) {
		this.fxId = fxId;
	}

	public String getFxGrade() {
		return fxGrade;
	}

	public void setFxGrade(String fxGrade) {
		this.fxGrade = fxGrade;
	}

	public String getIdentityStatus() {
		return identityStatus;
	}

	public void setIdentityStatus(String identityStatus) {
		this.identityStatus = identityStatus;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getRiskNum() {
		return riskNum;
	}

	public void setRiskNum(String riskNum) {
		this.riskNum = riskNum;
	}

	public String getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	public String getExamPeople() {
		return examPeople;
	}

	public void setExamPeople(String examPeople) {
		this.examPeople = examPeople;
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

	public String getNsrsbh() {
		return nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

	public String getExamManagerDepart() {
		return examManagerDepart;
	}

	public void setExamManagerDepart(String examManagerDepart) {
		this.examManagerDepart = examManagerDepart;
	}

	public String getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	
}
