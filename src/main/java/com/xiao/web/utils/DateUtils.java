package com.xiao.web.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
	public static String dateStr(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("MM月dd日 hh:mm");
		String str = format.format(date);
		return str;
	}
	
	public static String dateStr(Date date,String f) {
		SimpleDateFormat format = new SimpleDateFormat(f);
		String str = format.format(date);
		return str;
	}

	public static String dateStr2(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = format.format(date);
		return str;
	}

	public static String dateStr3(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = format.format(date);
		return str;
	}

	public static String dateStr4(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = format.format(date);
		return str;

	}
	public static String dateStr5(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String str = format.format(date);
		return str;

	}
	
	public static Date str2Date(String datestr) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(datestr);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}
	public static String dateStr6(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		String str = format.format(date);
		return str;
	}

	/**
	 * 将秒转换成时间
	 * @param times
	 * @return
	 */
	public static Date getDate(String times) {
		long time = Long.parseLong(times);
		return new Date(time*1000);
	}

	public static String dateStr(String times) {
		return dateStr(getDate(times));
	}
	public static String dateStr2(String times) {
		return dateStr2(getDate(times));
	}
	public static String dateStr3(String times) {
		return dateStr3(getDate(times));
	}
	public static String dateStr4(String times) {
		return dateStr4(getDate(times));
	}
	public static long getTime(Date date) {
		return date.getTime() / 1000;
	}

	public static int getDay(Date d){
		Calendar cal=Calendar.getInstance();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * s - 表示 "yyyy-mm-dd" 形式的日期的 String 对象 
	 * @param f
	 * @return
	 */
	public static Date valueOf(String s){
		final int YEAR_LENGTH = 4;
        final int MONTH_LENGTH = 2;
        final int DAY_LENGTH = 2;
        final int MAX_MONTH = 12;
        final int MAX_DAY = 31;
        int firstDash;
        int secondDash;
        Date d = null;

        if (s == null) {
            throw new java.lang.IllegalArgumentException();
        }

        firstDash = s.indexOf('-');
        secondDash = s.indexOf('-', firstDash + 1);
        if ((firstDash > 0) && (secondDash > 0) && (secondDash < s.length()-1)) {
            String yyyy = s.substring(0, firstDash);
            String mm = s.substring(firstDash + 1, secondDash);
            String dd = s.substring(secondDash + 1);
            if (yyyy.length() == YEAR_LENGTH && mm.length() == MONTH_LENGTH &&
                dd.length() == DAY_LENGTH) {
                int year = Integer.parseInt(yyyy);
                int month = Integer.parseInt(mm);
                int day = Integer.parseInt(dd);
                if (month >= 1 && month <= MAX_MONTH) {
                    int maxDays = MAX_DAY;
                    switch (month) {
                        // February determine if a leap year or not
                        case 2:
                            if((year % 4 == 0 && !(year % 100 == 0)) || (year % 400 == 0)) {
                                maxDays = MAX_DAY-2; // leap year so 29 days in February
                            } else {
                                maxDays = MAX_DAY-3; //  not a leap year so 28 days in February 
                            }
                            break;
                        // April, June, Sept, Nov 30 day months
                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            maxDays = MAX_DAY-1;
                            break;
                    }
                    if (day >= 1 && day <= maxDays) {
                        Calendar cal=Calendar.getInstance();
                        cal.set(year, month - 1, day,0,0,0);
                        cal.set(Calendar.MILLISECOND, 0);
                        d=cal.getTime();
                    }
                }
            }
        }
        if (d == null) {
            throw new java.lang.IllegalArgumentException();
        }
        return d;
	}
	
	/**
	 * @author lijie
	 * @param Begin
	 * @param end
	 * 传入开始时间 和 结束时间 格式如：2012-09-07
	 * @return
	 * 返回Map  获取相隔多少年 get("YEAR")及为俩个时间年只差，月 天，类推
	 *  Key ：
	 *  YEAR MONTH DAY
	 *  如果开始时间 晚于 结束时间 return null；
	 */
	
	public static Map getApartTime(String Begin, String end) {
		  String[] temp = Begin.split("-");
	        String[] temp2 = end.split("-");
	        if (temp.length > 1 && temp2.length > 1) {
	            Calendar ends = Calendar.getInstance();
	            Calendar begin = Calendar.getInstance();

	            begin.set(NumberUtils.getInt(temp[0]),
	                    NumberUtils.getInt(temp[1]), NumberUtils.getInt(temp[2]));
	            ends.set(NumberUtils.getInt(temp2[0]),
	                    NumberUtils.getInt(temp2[1]), NumberUtils.getInt(temp2[2]));
	            if (begin.compareTo(ends) < 0) {
	                Map map = new HashMap();
	                ends.add(Calendar.YEAR, -NumberUtils.getInt(temp[0]));
	                ends.add(Calendar.MONTH, -NumberUtils.getInt(temp[1]));
	                ends.add(Calendar.DATE, -NumberUtils.getInt(temp[2]));
	                map.put("YEAR", ends.get(Calendar.YEAR));
	                map.put("MONTH", ends.get(Calendar.MONTH) + 1);
	                map.put("DAY", ends.get(Calendar.DATE));
	                return map;
	            }
	        }
	        return null;
	}
	
	public static Date rollDay(Date d,int day){
		Calendar cal=Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}
	public static Date rollMon(Date d,int mon){
		Calendar cal=Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MONTH, mon);
		return cal.getTime();
	}
	public static Date rollYear(Date d,int year){
		Calendar cal=Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}
	public static Date rollDate(Date d,int year,int mon,int day){
		Calendar cal=Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, mon);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}
	
	
	/**
	 * 获取当前时间的秒数字符串
	 * @return
	 */
	public static String getNowTimeStr(){
		String str=Long.toString(System.currentTimeMillis() / 1000);
		return str;
	}
	
	public static String rollMonth(String addtime,String time_limit){
		Date t=DateUtils.rollDate(DateUtils.getDate(addtime), 0, NumberUtils.getInt(time_limit),0);
		return t.getTime()/1000+"";
	}
	
	public static String rollDay(String addtime,String time_limit_day){
		Date t=DateUtils.rollDate(DateUtils.getDate(addtime), 0, 0,NumberUtils.getInt(time_limit_day));
		return t.getTime()/1000+"";
	}
	
	public static Date getIntegralTime(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	public static Date getLastSecIntegralTime(Date d){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(d.getTime());
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	/**
	 * 时间字符串和当前系统时间进行比较
	 * @param dateStr
	 * @return
	 */
	public static int compareToNowDate(String dateStr){
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String nowStr = dateStr2(new Date());;
			Date nowDate = format.parse(nowStr);//当前时间
			Date date = format.parse(dateStr);//要比较的时间字符串
			int i = date.compareTo(nowDate); //【0】等于，【1】date大于nowDate，【-1】date小于nowDate
			return i;
		} catch (ParseException e) {
			e.printStackTrace();
			return -2;
		}

	}

	/**
	 * 匹配是否为日期格式yyyy-MM-dd
	 * @param date 
	 * @return
	 */
	public static boolean isDate(String date){     
        Pattern p = Pattern.compile("^((?:19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");     
        Matcher m = p.matcher(date);      
        return m.matches();     
    } 
	/** 
     * 求开始截至日期之间的天数差. 
     *  
     * @param d1 
     *            开始日期 
     * @param d2 
     *            截至日期 
     * @return 返回相差天数 
     */  
    public static int getDays(Date d1, Date d2) {  
        if (d1 == null || d2 == null)  
            return 0;  
        Date[] d = new Date[2];  
        d[0] = d1;  
        d[1] = d2;  
        Calendar[] cal = new Calendar[2];  
        for (int i = 0; i < cal.length; i++) {  
            cal[i] = Calendar.getInstance();  
            cal[i].setTime(d[i]);  
            cal[i].set(Calendar.HOUR_OF_DAY, 0);  
            cal[i].set(Calendar.MINUTE, 0);  
            cal[i].set(Calendar.SECOND, 0);  
        }  
        long m = cal[0].getTime().getTime();  
        long n = cal[1].getTime().getTime();  
        int ret = (int) (n - m) / 1000 / 3600 / 24;  
        return ret;  
    }  
  
	
	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
		
//        cal.set(2013,04,24,16,47,21);
//        cal.set(Calendar.MILLISECOND, 0);
//        Date d=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		System.out.println(sdf.format(d));
		
		try {
			System.out.println(getDays(sdf.parse("2015-11-10 00:00:01"),sdf.parse("2015-11-09 00:00:02")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		System.out.println(compareToNowDate("2015-01-19"));
	//	Long l = 1372089599000L;
	//	String s = DateUtils.dateStr5(new Date(l));
	//	System.out.println(s);
//		long l = 1L;
//		System.out.println(l==1);
//		System.out.println(l);
//		Long repaymentTime = 1369465200L;
//		Long currTime = System.currentTimeMillis();
//		String repaymentTimeStr = DateUtils.dateStr2(new Date(repaymentTime));
//		int days = (int) ((repaymentTime * 1000 - currTime) / (24 * 60 * 60 * 1000));
//		System.out.println(days);
		
//		long l = Long.valueOf(1345698756+"000");
//		String time = DateUtils.dateStr5(new Date(l));
//		String subject = "";
//		System.out.println(time);
		
	}
	
	// 判断时间是否在时间段内  
    public static boolean compareDate(String start, String end, Date date) {
    	SimpleDateFormat formate = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );  
   	    Date sdate = null;
   	    Date edate = null;
		
		try {
			sdate = formate.parse(start);
			edate = formate.parse(end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
			
        if (date.getTime() >= sdate.getTime() && date.getTime() <= edate.getTime()) {  
            return true;  
        }  
        return false;  
    }  
}
