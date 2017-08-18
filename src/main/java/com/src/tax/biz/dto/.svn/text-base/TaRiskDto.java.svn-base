package com.icinfo.tax.biz.dto;
import java.util.Date;
import javax.persistence.Transient;
import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.tax.biz.model.TaRisk;

public class TaRiskDto extends TaRisk{
	private static final long serialVersionUID = 1L;
	
	public final static String DJZCLXDM = ",110,141,143,151,161,162,164,165,200,210,220,230,240,250,251,252,253,254,255,259,300,310,320,330,340,350,351,352,353,354,355,359,290,390,412,413,422,423,432,433,510,530,540,550,560,";
	
	public final static String HYDM1 = ",0,1,2,3,4,9,";
	
	public final static String HYDM2 = ",63,64,66,67,68,69,70,73,76,77,78,80,83,84,85,86,88,";
	
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8") 
	private Date buildDateLeft;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date buildDateRight;
	
	private Integer fxGradeLeft;
	
	private Integer fxGradeRight;
	
	private Date examDateLeft;
	
	private Date examDateRight;
	//事前风险项
	private String riskName;

	private String nsrsbh;
  
    private String entName;
   
    private String managerDepart;
    
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date buildDate;
    //行业
    private String industry;
    
    private String legalPerson;
    
    private String financePerson;
   
    private String regisAddr;
    
    private String businessScope;
    
    private String hisNum;
    
    private String riskNumLeft;
    
    private String riskNumRight;
    //风险月份左
    private String riskMonthLeft;
    //风险月份右
    private String riskMonthRight;
    //事前风险核查数量
    private Integer beforeRiskExamNum;
    //事中风险核查数量
    private Integer afterRiskExamNum;
    //事前风险总数
    private Integer beforeRiskNum;
    //事中风险总数
    private Integer afterRiskNum;
    //风险类型
    private String riskType;
    
	private String identityStatusDesc;

	private Integer examStatusDesc;
	//行业代码
	public String industryCode;
	//登记注册类型代码
	public String dJZcLcDm;
	
	private String riskSign;
	
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

	public String getManagerDepart() {
		return managerDepart;
	}
	
	public void setManagerDepart(String managerDepart) {
		this.managerDepart = managerDepart;
	}

	public Date getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getFinancePerson() {
		return financePerson;
	}

	public void setFinancePerson(String financePerson) {
		this.financePerson = financePerson;
	}

	public String getRegisAddr() {
		return regisAddr;
	}

	public void setRegisAddr(String regisAddr) {
		this.regisAddr = regisAddr;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public Date getBuildDateLeft() {
		return buildDateLeft;
	}

	public void setBuildDateLeft(Date buildDateLeft) {
		this.buildDateLeft = buildDateLeft;
	}

	public Date getBuildDateRight() {
		return buildDateRight;
	}

	public void setBuildDateRight(Date buildDateRight) {
		this.buildDateRight = buildDateRight;
	}

	public Integer getFxGradeLeft() {
		return fxGradeLeft;
	}

	public void setFxGradeLeft(Integer fxGradeLeft) {
		this.fxGradeLeft = fxGradeLeft;
	}

	public Integer getFxGradeRight() {
		return fxGradeRight;
	}

	public void setFxGradeRight(Integer fxGradeRight) {
		this.fxGradeRight = fxGradeRight;
	}

	public Date getExamDateLeft() {
		return examDateLeft;
	}

	public void setExamDateLeft(Date examDateLeft) {
		this.examDateLeft = examDateLeft;
	}

	public Date getExamDateRight() {
		return examDateRight;
	}

	public void setExamDateRight(Date examDateRight) {
		this.examDateRight = examDateRight;
	}
	
	public String getRiskTypeDesc() {
		if("CURRENT".equals(this.getRiskType()))
			return "事中风险";
		return "事前风险";
	}

	public String getExamStatusDesc() {
		if(StringUtils.isNotBlank(this.getExamStatus()))
			return "已处理";
		return "待处理";
	}

	public String getHisNum() {
		return hisNum;
	}

	public void setHisNum(String hisNum) {
		this.hisNum = hisNum;
	}

	public String getRiskNumLeft() {
		return riskNumLeft;
	}

	public void setRiskNumLeft(String riskNumLeft) {
		this.riskNumLeft = riskNumLeft;
	}

	public String getRiskNumRight() {
		return riskNumRight;
	}

	public void setRiskNumRight(String riskNumRight) {
		this.riskNumRight = riskNumRight;
	}

	public String getRiskMonthLeft() {
		return riskMonthLeft;
	}

	public void setRiskMonthLeft(String riskMonthLeft) {
		this.riskMonthLeft = riskMonthLeft;
	}

	public String getRiskMonthRight() {
		return riskMonthRight;
	}

	public void setRiskMonthRight(String riskMonthRight) {
		this.riskMonthRight = riskMonthRight;
	}

	public Integer getBeforeRiskExamNum() {
		return beforeRiskExamNum;
	}

	public void setBeforeRiskExamNum(Integer beforeRiskExamNum) {
		this.beforeRiskExamNum = beforeRiskExamNum;
	}

	public Integer getAfterRiskExamNum() {
		return afterRiskExamNum;
	}

	public void setAfterRiskExamNum(Integer afterRiskExamNum) {
		this.afterRiskExamNum = afterRiskExamNum;
	}

	public Integer getBeforeRiskNum() {
		return beforeRiskNum;
	}

	public void setBeforeRiskNum(Integer beforeRiskNum) {
		this.beforeRiskNum = beforeRiskNum;
	}

	public Integer getAfterRiskNum() {
		return afterRiskNum;
	}

	public void setAfterRiskNum(Integer afterRiskNum) {
		this.afterRiskNum = afterRiskNum;
	}

	@Override
	public String toString() {
		return "nsrsbh=" + nsrsbh + "^^ entName=" + entName + "^^ fxGrade="
				+ super.getFxGrade() + "^^ riskNum=" + super.getRiskNum() + "^^ identityStatus=" + super.getIdentityStatus() + "^^ examStatus="
				+ super.getExamStatus() + "^^ examPeople=" + super.getExamPeople() + "^^ examDate=" + super.getExamDate() + "^^ managerDepart=" + managerDepart
				+ "^^ buildDate=" + buildDate + "^^ industry=" + industry
				+ "^^ legalPerson=" + legalPerson + "^^ financePerson=" + financePerson + "^^ regisAddr=" + regisAddr
				+ "^^ businessScope=" + businessScope;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public void setExamStatusDesc(Integer examStatusDesc) {
		this.examStatusDesc = examStatusDesc;
	}

	public String getIdentityStatusDesc() {
		String identity = "";
//		if(super.getFxGrade()==null || this.getIndustryCode()==null || this.getdJZcLcDm()==null || super.getRiskType()==null){
//			return identity;
//		}
//		if(DJZCLXDM.contains(this.getdJZcLcDm())){
//			identity = "轻微风险";
//		}else if(HYDM1.contains(this.getIndustryCode().substring(0, 1))){
//			identity = "轻微风险";
//		}else if(HYDM2.contains(this.getIndustryCode().substring(0, 2))){
//			identity = "轻微风险";
//		}else if("ADVANCE".equals(super.getRiskType()) && Integer.parseInt(super.getFxGrade()) >= 80 && this.getIndustryCode().startsWith("5")){
//			identity = "高危风险";
//		}else if("ADVANCE".equals(super.getRiskType()) && Integer.parseInt(super.getFxGrade()) >= 80 && Integer.parseInt(super.getFxGrade()) < 88 && this.getIndustryCode().startsWith("5")){
//			identity = "中度风险";
//		}else if("ADVANCE".equals(Integer.parseInt(super.getFxGrade()) >= 80)){
//			identity = "中度风险";
//		}else{
//			identity = "轻微风险";
//		}
		return identity;
	}

	public void setIdentityStatusDesc(String identityStatusDesc) {
		this.identityStatusDesc = identityStatusDesc;
	}

	public String getIndustryCode() {
		return industryCode;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	public String getdJZcLcDm() {
		return dJZcLcDm;
	}

	public void setdJZcLcDm(String dJZcLcDm) {
		this.dJZcLcDm = dJZcLcDm;
	}

	public String getRiskSign() {
		return riskSign;
	}

	public void setRiskSign(String riskSign) {
		this.riskSign = riskSign;
	}
	
}
