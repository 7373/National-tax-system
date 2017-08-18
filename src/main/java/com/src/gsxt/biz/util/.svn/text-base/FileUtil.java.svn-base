package com.icinfo.tax.biz.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.icinfo.tax.biz.dto.TaRiskDto;

/**
 * 文件工具类
 * @author fanzhen
 * @date20170425
 *
 */
public class FileUtil {

	/**
	 * fanzhen
	 * 20170425
	 * @param filepath
	 */
	public static void mkdir(String filepath){
		File file = new File(filepath);
		//文件不存在则创建
		if(!file.exists() && !file.isDirectory()){
			file.mkdirs();
		}
	}
	
	/**
	 * @author fanzhen
	 * @date 20170428
	 * @param str
	 * @return
	 */
	public static String isNull(Object str){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		if(str == null){
			return "";
		}
		if(str instanceof String){
			return (String)str;
		}
		if(str instanceof Date){
			return sdf.format(str);
		}
		return "";
	}
	/**
	 * 修饰管理科室
	 * @author fanzhen
	 * @date 20170428
	 * @return
	 */
	public static String managerDepart(String str){
		if("13301913300".equals(str)){
			return "一科";
		}else if("13301913100".equals(str)){
			return "二科";
		}else if("13301910000".equals(str)){
			return "暂未分科室";
		}
		return "不存在的科";
	}
	
	/**
	 * 导出Excel表格
	 * 
	 * @author fanzhen
	 * @return
	 * @serialData 2017-03-29
	 */
	public static boolean exportExcel(String title, Collection<TaRiskDto> dataList, OutputStream out,String type)
			throws Exception {
		try {
			 // 声明一个工作薄
		      HSSFWorkbook workbook = new HSSFWorkbook();
		      // 生成一个表格
		      HSSFSheet sheet = workbook.createSheet(title);
		      // 设置表格默认列宽度为15个字节
		      sheet.setDefaultColumnWidth((short) 20);
		      //产生表格标题行
		      HSSFRow row = sheet.createRow(0);
		      	if("ADVANCE".equals(type)){
		      		String[] header = {"社会信用代码","企业名称","事前风险评分","对应主要风险项","算法认定状态","最新核查状态","最新核查人","最新核查日期","管理科室","成立日期","行业","法人","财务联系人","注册地址","经营范围"};
				      for (short i = 0; i < header.length; i++) {
				         HSSFCell cell = row.createCell(i);
				         HSSFRichTextString text = new HSSFRichTextString(header[i]);
				         cell.setCellValue(text);
				      }
				      int index = 0;
		      			for(TaRiskDto dto:dataList){
			      		index++;
			      		row = sheet.createRow(index);
			      		HSSFCell cell0 = row.createCell(0);
				        cell0.setCellValue(isNull(dto.getNsrsbh()));
				        
				        HSSFCell cell1 = row.createCell(1);
				        cell1.setCellValue(isNull(dto.getEntName()));
				        
				        HSSFCell cell2 = row.createCell(2);
				        cell2.setCellValue(isNull(dto.getFxGrade()));
				        
				        HSSFCell cell3 = row.createCell(3);
				        cell3.setCellValue(isNull(dto.getRiskNum()));
				        
				        HSSFCell cell4 = row.createCell(4);
				        cell4.setCellValue(isNull(dto.getIdentityStatus()));
				        
				        HSSFCell cell5 = row.createCell(5);
				        cell5.setCellValue(isNull(dto.getExamStatus()));
				        
				        HSSFCell cell6 = row.createCell(6);
				        cell6.setCellValue(isNull(dto.getExamPeople()));
				        
				        HSSFCell cell7 = row.createCell(7);
				        cell7.setCellValue(isNull(dto.getExamDate()));
				        
				        HSSFCell cell8 = row.createCell(8);
				        cell8.setCellValue(managerDepart(isNull(dto.getManagerDepart())));
				        
				        HSSFCell cell9 = row.createCell(9);
				        cell9.setCellValue(isNull(dto.getBuildDate()));
				        
				        HSSFCell cell10 = row.createCell(10);
				        cell10.setCellValue(isNull(dto.getIndustry()));
				        
				        HSSFCell cell11 = row.createCell(11);
				        cell11.setCellValue(isNull(dto.getLegalPerson()));
				        
				        HSSFCell cell12 = row.createCell(12);
				        cell12.setCellValue(isNull(dto.getFinancePerson()));
				        
				        HSSFCell cell13 = row.createCell(13);
				        cell13.setCellValue(isNull(dto.getRegisAddr()));
				        
				        HSSFCell cell14 = row.createCell(14);
				        cell14.setCellValue(isNull(dto.getBusinessScope()));
			      	}
		      	}else if("CURRENT".equals(type)){
		      		String[] header = {"社会信用代码","企业名称","事中风险项","最新核查状态","最新核查人","最新核查日期","管理科室","成立日期","行业","法人","财务联系人","注册地址","经营范围"};
	      			for (short i = 0; i < header.length; i++) {
	  		         HSSFCell cell = row.createCell(i);
	  		         HSSFRichTextString text = new HSSFRichTextString(header[i]);
	  		         cell.setCellValue(text);
	  		      }
	      			int index = 0;
		      		for(TaRiskDto dto:dataList){
			      		index++;
			      		row = sheet.createRow(index);
			      		HSSFCell cell0 = row.createCell(0);
				        cell0.setCellValue(isNull(dto.getNsrsbh()));
				        
				        HSSFCell cell1 = row.createCell(1);
				        cell1.setCellValue(isNull(dto.getEntName()));
				        
				        HSSFCell cell2 = row.createCell(2);
				        cell2.setCellValue(isNull(dto.getRiskNum()));
				        
				        HSSFCell cell3 = row.createCell(3);
				        cell3.setCellValue(isNull(dto.getExamStatus()));
				        
				        HSSFCell cell4 = row.createCell(4);
				        cell4.setCellValue(isNull(dto.getExamPeople()));
				        
				        HSSFCell cell5 = row.createCell(5);
				        cell5.setCellValue(isNull(dto.getExamDate()));
				        
				        HSSFCell cell6 = row.createCell(6);
				        cell6.setCellValue(managerDepart(isNull(dto.getManagerDepart())));
				        
				        HSSFCell cell7 = row.createCell(7);
				        cell7.setCellValue(isNull(dto.getBuildDate()));
				        
				        HSSFCell cell8 = row.createCell(8);
				        cell8.setCellValue(isNull(dto.getIndustry()));
				        
				        HSSFCell cell9 = row.createCell(9);
				        cell9.setCellValue(isNull(dto.getLegalPerson()));
				        
				        HSSFCell cell10 = row.createCell(10);
				        cell10.setCellValue(isNull(dto.getFinancePerson()));
				        
				        HSSFCell cell11 = row.createCell(11);
				        cell11.setCellValue(isNull(dto.getRegisAddr()));
				        
				        HSSFCell cell12 = row.createCell(12);
				        cell12.setCellValue(isNull(dto.getBusinessScope()));
			      	}
		      	}
		      try {
		         workbook.write(out);
		      } catch (IOException e) {
		         e.printStackTrace();
		      }finally{
		    	  try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		      }
		 return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	     
	   }
}
