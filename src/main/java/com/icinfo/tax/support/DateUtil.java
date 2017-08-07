package com.icinfo.tax.support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 获取N天后日期
	 * 
	 * @param N
	 * @return
	 */
	public static Date getNdaylaterDate(Date date, int N) {
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.DAY_OF_YEAR, N);
			return now.getTime();
	}
	
	/**
	 * 获取某天开始时间
	 * 
	 * @param N
	 * @return
	 */
	public static Date getdayStartDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String str = formatter.format(date)+" 00:00:00";
		return stringToDate(str, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 获取某天结束时间
	 * 
	 * @param N
	 * @return
	 */
	public static Date getdayEndDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String str = formatter.format(date)+" 23:59:59";
		return stringToDate(str, "yyyy-MM-dd HH:mm:ss");
	}
	
	
	/**
	 * 获取N月后时间
	 * 
	 * @param N
	 * @return
	 */
	public static String getNmonthlater(Date date, int N) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MONTH, N);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
		return formatter.format(now.getTime());
	}
	/**
	 * 把字符转为日期
	 * 
	 * @param strDate
	 * @param
	 * @return
	 */
	public static Date stringToDate(String strDate, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(strDate);
		} catch (Exception er) {
			return null;
		}
	}
	
	/**
	 * 获取某月的第一天
	 * 
	 */
	public static String getFirstDayForMonth(Calendar c){
//			Calendar cal = Calendar.getInstance();
			c.set(Calendar.DAY_OF_MONTH, c.getMinimum(Calendar.DATE));
			return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
}
	/**
	 * 获取某月的最后一天
	 * 
	 */
	public static String getLastDayForMonth(Calendar c){
//		  Calendar cal = Calendar.getInstance();
//		  cal.set(Calendar.MONTH, c.get(Calendar.MONTH));
//		  cal.set(Calendar.YEAR,c.get(Calendar.YEAR));
		  c.set(Calendar.DAY_OF_MONTH, 1);
		  int value = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		  c.set(Calendar.DAY_OF_MONTH, value);
		  return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}
	/**
	 * 获取某月份数
	 * num:0   代表当月
	 */
	public static Calendar getMonth(Date  date,int num){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, num);
		return cal;
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(getMonth(new Date(),1).get(Calendar.MONTH));
//		System.out.println(getFirstDayForMonth(getMonth(new Date(),6)));
//		System.out.println(getMonth(new Date(),3).getYear()+"===="+getMonth(new Date(),3).getMonth());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		try {
			Date date = getMonth(format.parse("201703"),1).getTime();
			System.out.println(getFirstDayForMonth(getMonth(date,1)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
