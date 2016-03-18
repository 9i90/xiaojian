package com.xiao.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xiao.web.entity.ArticleInfo;
import com.xiao.web.service.ArticleService;
import com.xiao.web.utils.IpUtil;

@Controller
public class ArticleController extends BaseController{
	@Autowired
	private ArticleService articleService;
	
	/**
	 * 文章查看
	 * @return
	 */
	@RequestMapping("/news/{id}")
	public ModelAndView index(@PathVariable("id")String id,HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv=new ModelAndView("article");
		ArticleInfo info = articleService.findArticleById(id);
		request.setAttribute("info", info);
		
		Integer uid = null;
		try{
			if(request.getParameter("uid")!=null)
			uid = Integer.parseInt(request.getParameter("uid"));
		}catch(Exception e){
			uid=null;
		}
		if(info!=null){
			articleService.saveArticleReadRecord(uid, id, IpUtil.getIpAddr(request), request.getSession().getId());
		}
		return mv;
	}
}
