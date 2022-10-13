package com.bikego.env.management.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理日期
 * 
 *
 */
public final class DateUtils {
	
	private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

	public static final String YYYYMMDD = "yyyy-MM-dd";
	public static final String YYYYMMDDTT = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMDD = "yyyy-M-dd";
	public static final String YYYYMD = "yyyy-M-d";
	public static final String YYYYMMD = "yyyy-MM-d";
	public static final String TT = "HH:mm:ss";
	public static final String YYYYMM = "yyyyMM";
	public static final String MMDD = "MM.dd";
	public static final String YYMMDD = "yyMMdd";

	private DateUtils() {
	}

	public static String format_HMS(Timestamp ts) {
		return String.valueOf(ts.getTime());
	}

	public static String format_HMS(Date date) {
		return getDateByYYMMDDTT(date);
	}

	public static String addDays(Date date, int days) {
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(date);
		gCal.add(GregorianCalendar.DAY_OF_MONTH, days);
		return getDateByYYMMDDTT(gCal.getTime());
	}

	public static String addMonths(Date date, int months) {
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(date);
		gCal.add(GregorianCalendar.MONTH, months);
		return getDateByYYMMDD(gCal.getTime());
	}
	public static Date getDateByaddMonths(Date date, int months) {
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(date);
		gCal.add(GregorianCalendar.MONTH, months);
		return gCal.getTime();
	}

	public static String addHours(Date date, int hours) {
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(date);
		gCal.add(GregorianCalendar.HOUR_OF_DAY, hours);
		return getDateByYYMMDDTT(gCal.getTime());
	}

	public static Date addMinutes(Date date, int minutes) {
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(date);
		gCal.add(GregorianCalendar.MINUTE, minutes);
		return gCal.getTime();
	}

	/**
	 * date2比date1多的天数 ,精确到时分秒
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int dateSub(Date date1, Date date2) {
		long daterange = date1.getTime() - date2.getTime();
		return (int) (daterange / (1000 * 3600 * 24));
	}

	/**
	 * date2比date1多的天数 ,不精确到时分秒
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentDays(Date date1,Date date2)
	{
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day1= cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if(year1 != year2){ //同一年
			int timeDistance = 0 ;
			for(int i = year1 ; i < year2 ; i ++)
			{
				if(i%4==0 && i%100!=0 || i%400==0) {  //闰年
					timeDistance += 366;
				} else{ //不是闰年
					timeDistance += 365;
				}
			}
			return timeDistance + (day2-day1) ;
		} else{//不同年
			//System.out.println("判断day2 - day1 : " + (day2-day1));
			return day2-day1;
		}
	}

	/**
	 * 将日期SQL日期格式解析成yyyy-MM-dd格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateByYYMMDD(java.sql.Date date) {
		if (date == null)
			return "";
		SimpleDateFormat dateFormatYYMMDD = new SimpleDateFormat(
				DateUtils.YYYYMMDD);
		return dateFormatYYMMDD.format(date);
	}

	/**
	 * 将日期格式解析成yyyy-MM-dd格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateByYYMMDD(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat dateFormatYYMMDD = new SimpleDateFormat(
				DateUtils.YYYYMMDD);
		return dateFormatYYMMDD.format(date);
	}

	/**
	 * 将日期SQL日期格式解析成yyyy-MM-dd HH:mm:ss格式的字符串
	 * 
	 * @param date
	 * @return
	 */

	public static String getDateByYYMMDDTT(java.sql.Date date) {
		if (date == null)
			return "";
		SimpleDateFormat dateFormatYYMMDDTT = new SimpleDateFormat(
				DateUtils.YYYYMMDDTT);
		return dateFormatYYMMDDTT.format(date);
	}

	/**
	 * 将日期格式解析成yyyy-MM-dd HH:mm:ss格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateByYYMMDDTT(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat dateFormatYYMMDDTT = new SimpleDateFormat(
				DateUtils.YYYYMMDDTT);
		return dateFormatYYMMDDTT.format(date);
	}

	/**
	 * 将日期格式解析成yyyy-MM-dd格式的字符串
	 * 
	 * @param
	 * @return
	 */
	public static String getDateByNowYYMMDD() {
		return getDateByYYMMDD(new Date());
	}

	/**
	 * 将日期格式解析成yyyy-MM-dd HH:mm:ss格式的字符串
	 * 
	 * @param
	 * @return
	 */
	public static String getDateByNowYYMMDDTT() {
		return getDateByYYMMDDTT(new Date());
	}

	/**
	 * 将日期格式解析成HH:mm:ss格式的字符串
	 * 
	 * @return
	 */
	public static String getDateByNowTT() {
		SimpleDateFormat dateFormatTT = new SimpleDateFormat(DateUtils.TT);
		return dateFormatTT.format(new Date());
	}

	public static Date getMonthDateLastDay(Date date) {
		GregorianCalendar gc = (GregorianCalendar) GregorianCalendar
				.getInstance();
		gc.setTime(date);
		gc.set(Calendar.DAY_OF_MONTH, gc.getActualMaximum(Calendar.DAY_OF_MONTH));
		return gc.getTime();
	}

	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static long getDate(String date, String format)
			throws ParseException {
		if (date.length() == 4)// mysql有year这个数据类型
		{
			throw new IllegalArgumentException();
			// SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			// return dateFormat.parse(date).getTime();
		} else if (date.length() > 4 && date.length() <= 7) {
			throw new IllegalArgumentException();
			// SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			// return dateFormat.parse(date).getTime();
		} else if (date.trim().length() <= 10) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(date + " 00:00:00").getTime();
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(date).getTime();
		}
	}

	public static long getTime(String time, String format)
			throws ParseException {
		if (time.length() <= 8) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(time).getTime();
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(time).getTime();
		}
	}

	public static Date parseDate(String date, String format)
			throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(date);
	}

	public static String getDate(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * 得到类似yyyyMM格式的日期字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateByYYYMM(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtils.YYYYMM);
		return dateFormat.format(date);
	}

	public static String getDateByNowYYYYMM() {
		return getDateByYYYMM(new Date());
	}

	/**
	 * 返回日期的yyyy-MM-dd格式时间 时分秒为零
	 * @param dateStr
	 * @return
	 */
	public static Date getYYYYMMDDFromLong(Long dateStr) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(dateStr);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return c.getTime();

	}
	/** 
	*字符串的日期格式的计算 
	*/  
    public static int daysBetween(long begin,long end) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Date begin_d  = new Date(begin);
        Date end_d  = new Date(end);
        long between_days = 0 ;
        Date begin_dd ;
        Date end_dd;
		try {
			begin_dd = sdf.parse(sdf.format(begin_d));
			end_dd =sdf.parse(sdf.format(end_d));
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(begin_dd);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(end_dd);    
	        long time2 = cal.getTimeInMillis();         
	        between_days=(time2-time1)/(1000*3600*24);  
		} catch (ParseException e) {
			logger.error("计算两个日期相隔几天失败",e);
		} 
       return Integer.parseInt(String.valueOf(between_days));     
    }

	/**
	 * startDate 大于 endDate 时返回true
	 * @param startDate
	 * @param endDate
	 * @return
     */
	public static boolean compareToDate(Date startDate,Date endDate){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String startDateStr=df.format(startDate);
		String endDateStr=df.format(endDate);
		try {
			Long start=df.parse(startDateStr).getTime();
			Long end=df.parse(endDateStr).getTime();
			return start-end>0?true:false;
		}catch (ParseException e){
			return false;
		}
	}

	/**
	 *  startDate 大于 endDate 时返回true
	 * @param startDate
	 * @param endDate
     * @return
     */
	public static boolean compareToDate(String startDate,String endDate){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Long start=df.parse(startDate).getTime();
			Long end=df.parse(endDate).getTime();
			return start-end>0?true:false;
		}catch (ParseException e){
			return false;
		}
	}

	/**
	 * 将日期格式解析成yyMMdd格式没有-符号的字符串
	 *
	 * @return
	 */
	public static String getSixNum() {
		SimpleDateFormat dateFormatYYMMDDTT = new SimpleDateFormat(
				DateUtils.YYMMDD);
		return dateFormatYYMMDDTT.format(new Date());
	}
}
