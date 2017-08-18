package com.icinfo.tax.biz.dto;

import java.io.Serializable;

import java.math.BigDecimal;

public class QuartzDto implements Serializable{

	private static final long serialVersionUID = -3764089176373877585L;
	
	private String bsNsrsbh;
	
	private String gfQymc;
	
	private BigDecimal je;

	public String getBsNsrsbh() {
		return bsNsrsbh;
	}

	public void setBsNsrsbh(String bsNsrsbh) {
		this.bsNsrsbh = bsNsrsbh;
	}

	public String getGfQymc() {
		return gfQymc;
	}

	public void setGfQymc(String gfQymc) {
		this.gfQymc = gfQymc;
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}
	
	
}
