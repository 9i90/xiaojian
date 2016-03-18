package com.xiao.web.controller;


import javax.servlet.http.HttpServletRequest;
import com.xiao.web.pojo.LoginInfo;

public class BaseController {
	static String encoding = "UTF-8";
	
	protected LoginInfo getLoginInfo(HttpServletRequest request){
		return (LoginInfo)request.getSession().getAttribute("SESSION_USER_INFO");
	}
}
