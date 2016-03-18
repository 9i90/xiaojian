package com.xiao.web.cached;
/**
 * memcache的Key 常量类
 * @Package com.idesky.server.cache
 * @author xiajiang.yu
 * @Description: TODO
 * @date 2015年1月8日 下午2:54:06
 * @version V1.0
 */
public class CacheKeyConstant {
	/*统计用户注册总数的缓存key*/
	public static String HH_P2PTRADEPLATFORM_USERREGISTERCOUNT="hh_p2ptradeplatform_userregistercount";
	/**
	 * wy add at 20150110
	 * return List[site_Id ,name 栏目名称,pid 父类ID,rank 栏目级别  1：一级栏目；2：二级栏目 ,order 排序；location：栏目显示位置【前台网站显示位置  多个以应为逗号分割【dw_code_details;SITE_LOCATION;HELP:帮助中心;ABOUTUS:关于我们;BANNERBOTTOM:BANNER下面显示;NEWS:新闻公告;WEBBOTTOM:网站底部;WEBCENTER:内容中心】】]
	 * 
	 * 获取一级栏目信息*/
	public static String HH_P2PMANAGESYS_SITECACHE="hh_p2pmanagesys_sitecache";
	/**
	 * 首页banner的查询缓存key
	 */
	public static String HH_P2PMANAGESYS_BANNERCACHE="hh_p2pmanagesys_bannercache";
	
	/**获取导航栏中的值的缓存key*/
	public static String HH_P2PMANAGESYS_NAVIGATIONBAR="hh_p2pmanagesys_navigationbar";
	
	/**获取缓存中微信的access_token的key*/
	public static String HH_WECHAT_ACCESS_TOKEN="hh_wechat_access_token";
	
	/**获取缓存中微信js使用票据的key*/
	public static String HH_WECHAT_JSAPI_TICKET="hh_wechat_jsapi_ticket";
	
}
