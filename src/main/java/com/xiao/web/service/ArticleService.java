package com.xiao.web.service;

import java.util.List;
import java.util.Map;

import com.xiao.web.entity.ArticleInfo;
import com.xiao.web.page.Page;

public interface ArticleService {
	void saveArticleReadRecord(Integer shareUserId,String articleId,String ip,String sessionId);
	
	ArticleInfo findArticleById(String id);
	
	List<Map>  queryArticleByWhere(Map param,Page p);
}
