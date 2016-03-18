package com.xiao.web.service;

import com.xiao.web.entity.ArticleInfo;

public interface ArticleService {
	void saveArticleReadRecord(Integer shareUserId,String articleId,String ip,String sessionId);
	
	ArticleInfo findArticleById(String id);
}
