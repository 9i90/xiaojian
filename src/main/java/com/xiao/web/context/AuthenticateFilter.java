package com.xiao.web.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.xiao.web.pojo.LoginInfo;
import com.xiao.web.utils.IpUtil;

/**
 * 
 * 功能：鉴权过滤器
 * 版本：v1.0
 * 创建人：luo90
 * 创建时间：2015-1-4 下午1:28:22   
 * 修改历史：
 * 			description by author@date
 */
public class AuthenticateFilter implements Filter {
	private Logger log = Logger.getLogger(AuthenticateFilter.class);
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		Integer uid = null;
		try{
			if(httpRequest.getParameter("uid")!=null)
				uid = Integer.parseInt(httpRequest.getParameter("uid"));
		}catch(Exception e){
			uid = null;
		}
		if(session.getAttribute("SESSION_USER_INFO")==null){
			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setUserId(uid);
			loginInfo.setLoginTime(new Date());
			loginInfo.setSessionId(session.getId());
			loginInfo.setLoginIp(IpUtil.getIpAddr(httpRequest));
			session.setAttribute("SESSION_USER_INFO", loginInfo);
		}else{
			LoginInfo loginInfo = (LoginInfo)session.getAttribute("SESSION_USER_INFO");
			if(loginInfo.getUserId()==null&&uid!=null)
				loginInfo.setUserId(uid);
		}
		
		//验证通过，可以放行
		chain.doFilter(request, response);
		return;
	}

	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}