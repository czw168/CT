package cn.ubot.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 日期工具类
 * @author victor_chen
 *
 */
public class DateUtils {
	// 常用日期格式
	private static final String []patterns = {
			"yyyy-MM-dd",
			"yyyy-MM-dd hh:mm:ss",
			"yyyy年MM月dd日",
			"yyyy年MM月dd日 hh:mm:ss",
			"yyyy/MM/dd"
	};
	
	/**
	 * 日期解析
	 * @param dateStr 要解析的日期字符串
	 * @param pattern 指定的日期格式
	 * 支持的日期格式：<br/>
	 * 1、"yyyy-MM-dd" <br/>
	 * 2、"yyyy-MM-dd hh:mm:ss" <br/>
	 * 3、"yyyy年MM月dd日" <br/>
	 * 4、"yyyy年MM月dd日 hh:mm:ss" <br/>
	 * 5、"yyyy/MM/dd" <br/>
	 * @return 日期对象
	 * @throws Exception
	 */
	public static Date parse(String dateStr,String pattern)throws Exception{
		if(null == pattern || "".equals(pattern.trim())){
			// 未指定日期格式，使用内置格式
			for(String ptn:patterns){
				try {
					return new SimpleDateFormat(ptn).parse(dateStr);
				} catch (Exception e) {}
			}
		}else{
			try {
				return new SimpleDateFormat(pattern).parse(dateStr);
			} catch (Exception e) {
				throw new Exception("解析日期错误：日期格式错误。");
			}
		}
		
		throw new Exception("解析日期错误：日期格式错误。");
	}
	
	
	/**
	 * 日期格式化<br/>
	 * @param date 要格式化的日期
	 * @param pattern 指定的格式化日期格式
	 * @return 格式化的日期字符串
	 * @throws Exception 日期格式化错误
	 */
	public static String format(Date date,String pattern)throws Exception{
		if(null == pattern || "".equals(pattern.trim())){
			// 未给定日期格式，使用默认 日期格式
			for(String ptn:patterns){
				try {
					return new SimpleDateFormat(ptn).format(date);
				} catch (Exception e) {}
			}
		}else{
			// 按指定的格式格式化日期对象
			try {
				return new SimpleDateFormat(pattern).format(date);
			} catch (Exception e) {
				throw new Exception("日期格式错误：日期格式错误。");
			}
		}
		
		throw new Exception("日期格式错误：日期格式错误。");
	}
	
	/**
     * 获取上个月第一天
     * @return
     */
    public static Date getFirstDayOfLastMonth(){
    	Calendar c = Calendar.getInstance();
    	c.add(Calendar.MONTH, -1);
    	c.set(Calendar.DAY_OF_MONTH,1);
    	c.set(Calendar.HOUR_OF_DAY,	0);
    	c.set(Calendar.MINUTE, 0);
    	c.set(Calendar.SECOND, 0);
    	return c.getTime();
    }
    
    /**
     * 获取上个月最后一天
     * @return
     */
    public static Date getLastDayOfLastMonth(){
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar c = Calendar.getInstance();
    	c.add(Calendar.MONTH, -1);
    	c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
    	
    	String dateStr = format.format(c.getTime());
    	try{
    		return parse(dateStr+" 23:59:59","yyyy-MM-dd hh:mm:ss");
    	}catch(Exception e){
    		return null;
    	}
    	
    }
    
    /**
     * 获取日期的年份
     * @param date
     * @return
     */
    public static int getYear(Date date){
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	return c.get(Calendar.YEAR);
    }
    
    /**
     * 获取日期的月份
     * @param date
     * @return
     */
    public static int getMonth(Date date){
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	return c.get(Calendar.MONTH)+1;	
    }
    
    /**
     * 获取上一年的年份
     * @return
     */
    public static int getLastYear(){
    	Calendar c = Calendar.getInstance();
    	c.add(Calendar.YEAR, -1);
    	return c.get(Calendar.YEAR);
    }
    
    /**
     * 获取某年某月的最后一天
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month){
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar c = Calendar.getInstance();
    	c.set(Calendar.YEAR, year);
    	c.set(Calendar.MONTH, month-1);
    	c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
    	String dateStr = format.format(c.getTime());
    	return dateStr;
    }
	
}
