package com.xiao.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xiao.web.entity.ArticleInfo;
import com.xiao.web.page.Page;
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
	@RequestMapping(value={"/article/detail/{id}"},method=RequestMethod.GET)
	public ModelAndView detail(@PathVariable("id")String id,HttpServletRequest request,
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
	/**
	 * 栏目查询
	 * @return
	 */
	@RequestMapping(value={"/{site}"},method=RequestMethod.GET)
	public ModelAndView siteArticle(@PathVariable("site")String site,HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv=new ModelAndView("list");
		Map param = new HashMap();
		Page page = new Page();
		List<Map> list = articleService.queryArticleByWhere(param, page);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("site", site);
		return mv;
	}
}
