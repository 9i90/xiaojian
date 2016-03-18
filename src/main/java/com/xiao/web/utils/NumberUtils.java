package com.xiao.web.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberUtils {
	public static double format(double d,String format){
		DecimalFormat df = new DecimalFormat(format); 
		String ds=df.format(d);
		return Double.parseDouble(ds);
	}
	
	public static double format2(double d){
		DecimalFormat df = new DecimalFormat("0.00"); 
		String ds=df.format(format6(d));
		return Double.parseDouble(ds);
	}
	
	public static String format2Str(double d){
		DecimalFormat df = new DecimalFormat("0.00"); 
		String ds=df.format(d);
		return ds;
	}
	
	public static double format4(double d){
		DecimalFormat df = new DecimalFormat("0.0000"); 
		String ds=df.format(d);
		return Double.parseDouble(ds);
	}
	
	public static double format6(double d){
		DecimalFormat df = new DecimalFormat("0.000000"); 
		String ds=df.format(d);
		return Double.parseDouble(ds);
	}
	
	public static double getDouble(String str){
		if(str==null||str.equals(""))
			return 0.0;
		double ret=0.0;
		try {
			ret=Double.parseDouble(str);
		} catch (NumberFormatException e) {
			ret=0.0;
		}
		return format6(ret);
	}
	
	public static long getLong(String str){
		if(str==null||str.equals(""))
			return 0L;
		long ret=0;
		try {
			ret=Long.parseLong(str);
		} catch (NumberFormatException e) {
			ret=0;
		}
		return ret;
	}
	
	public static Long[] getLongs(String[] str){
		
		if(str==null||str.length<1)
			return new Long[]{0L};
		Long[] ret=new Long[str.length];
		for(int i=0;i<str.length;i++){
			ret[i]=getLong(str[i]);
		}
		return ret;
	}
	
	public static int getInt(String str){
		if(str==null||str.equals(""))
			return 0;
		int ret=0;
		try {
			ret=Integer.parseInt(str);
		} catch (NumberFormatException e) {
			ret=0;
		}
		return ret;
	}
	
	public static int compare(double x,double y){
		BigDecimal val1=new BigDecimal(x);
		BigDecimal val2=new BigDecimal(y);
		return val1.compareTo(val2);
	}
	
	/**
	 * @param d
	 * @param len
	 * @return
	 */
	public static double ceil(double d,int len){
		String str=Double.toString(d);
		int a=str.indexOf(".");
		if(a+3>str.length()){
			a=str.length();
		}else{
			a=a+3;
		}
		str=str.substring(0, a);
		return Double.parseDouble(str);
	}
	
	public static double ceil(double d){
		return ceil(d,2);
	}
	
	public static long getRandom(int len){
		double r=Math.random();
		for(int i=0;i<len;i++){
			r=r*10;
		}
		long ret=(long)r;
		return ret;
	}
	
	//转换成带千分位的格式
	public static String getDecimalFormat(BigDecimal i){
		String str = DecimalFormat.getNumberInstance().format(i);
		return str;
	}
	//转换成Currency格式
	public static String getCurrencyFormat(BigDecimal i){
		String currecy = NumberFormat.getCurrencyInstance().format(i);
		return currecy;
	}
	
	public static String getPercent(String num ){
		
		double percent = Double.parseDouble(num);
	    //获取格式化对象
	    NumberFormat nt = NumberFormat.getPercentInstance();
	    //设置百分数精确度2即保留两位小数
	    nt.setMinimumFractionDigits(0);
	    //最后格式化并输出
//	    System.out.println("百分数：" + nt.format(percent));
		
		
		return nt.format(percent);
		
	}
}
