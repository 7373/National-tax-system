package com.icinfo.tax.biz.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
/**
 * 行业实体类
 * @author fanzhen
 * @date 20170502
 *
 */
@Table(name="DM_GY_HY")
public class Industry implements Serializable{

	private static final long serialVersionUID = 2876919264764750559L;
	
    @Column(name = "HY_DM")
    //行业代码
	private String area;
    //行业名称
    @Column(name="HYMC")
	private String hyMc;
    //上级行业代码
    @Column(name="SJHY_DM")
	private String sjHyDm;
    
    private String parentId;
    
    private String noCheck;
    
    private String isParent;
    
    public Industry(){}
    
	public Industry(String area, String hyMc, String parentId) {
		super();
		this.area = area;
		this.hyMc = hyMc;
		this.parentId = parentId;
	}

	public String getarea() {
		return area;
	}

	public void setarea(String area) {
		this.area = area;
	}

	public String getHyMc() {
		return hyMc;
	}

	public void setHyMc(String hyMc) {
		this.hyMc = hyMc;
	}

	public String getSjHyDm() {
		return sjHyDm;
	}

	public void setSjHyDm(String sjHyDm) {
		this.sjHyDm = sjHyDm;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getNoCheck() {
		return noCheck;
	}

	public void setNoCheck(String noCheck) {
		this.noCheck = noCheck;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	@Override
	public String toString() {
		return "Industry [area=" + area + ", hyMc=" + hyMc + ", sjHyDm=" + sjHyDm + ", parentId=" + parentId
				+ ", noCheck=" + noCheck + ", isParent=" + isParent + "]";
	}
    
}
