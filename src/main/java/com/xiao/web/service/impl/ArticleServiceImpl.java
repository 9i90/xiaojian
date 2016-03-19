package com.xiao.web.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiao.web.dao.ArticleInfoDao;
import com.xiao.web.entity.ArticleInfo;
import com.xiao.web.entity.ArticleReadRecord;
import com.xiao.web.page.Page;
import com.xiao.web.page.PageInterceptor;
import com.xiao.web.service.ArticleService;
@Service(value="articleService")
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleInfoDao articleInfoDao;
	@Override
	public void saveArticleReadRecord(Integer shareUserId, String articleId,
			String ip, String sessionId) {
		ArticleReadRecord record = new ArticleReadRecord();
		record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		record.setAddip(ip);
		record.setAddtime(new Date());
		record.setArticleId(articleId);
		record.setSessionId(sessionId);
		record.setShareUserId(shareUserId);
		articleInfoDao.saveEntity("com.xiao.web.dao.ArticleReadRecordMapper.insertSelective", record);
		
		articleInfoDao.updateReadCount(articleId);
	}
	@Override
	public ArticleInfo findArticleById(String id) {
		return articleInfoDao.selectByPrimaryKey(id);
	}
	@Override
	public List<Map> queryArticleByWhere(Map param, Page p) {
		if(param==null)param = new HashMap();
		param.put(PageInterceptor.PAGE_KEY, p);
		return articleInfoDao.queryArticleByWhere(param);
	}

}
