package com.icinfo.tax.biz.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "TA_ENT_MAINTAIN")
public class TaEntMaintain implements Serializable{

	private static final long serialVersionUID = -6453819922525492955L;
	/**
     * 主键
     */
    @Id
    @Column(name = "ID")
	private String id;
    @Column(name = "NSRSBH")
	private String nsrsbh;
	@Column(name="ENT_NAME")
	private String entName;
	@Column(name="AUTHOR")
	private String author;
	@Column(name="AUTHOR_ID")
	private String authorID;
	@Column(name="ZGSWSKFJ_DM")
	private String zgswskfjDm;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNsrsbh() {
		return nsrsbh;
	}
	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthorID() {
		return authorID;
	}
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}
	public String getZgswskfjDm() {
		return zgswskfjDm;
	}
	public void setZgswskfjDm(String zgswskfjDm) {
		this.zgswskfjDm = zgswskfjDm;
	}
	
	
}
