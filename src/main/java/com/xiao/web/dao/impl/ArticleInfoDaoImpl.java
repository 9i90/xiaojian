package com.xiao.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.xiao.web.dao.ArticleInfoDao;
import com.xiao.web.entity.ArticleInfo;
import com.xiao.web.page.Page;

@Repository("articleInfoDao")
public class ArticleInfoDaoImpl extends BaseDaoImpl implements ArticleInfoDao{

	@Override
	public ArticleInfo selectByPrimaryKey(String id) {
		return getSqlSession().selectOne("com.xiao.web.dao.ArticleInfoMapper.selectByPrimaryKey",id);
	}


	@Override
	public List selectArticeByWhere(Map param,Page p) {
//		int total = getSqlSession().selectOne("com.idesky.crowdfund.server.dao.ArticleInfoDao.selectArticeBySiteIdPhone_count", siteIds);
//		p.setTotal(total);
		return this.getSqlSession().selectList("com.xiao.web.dao.ArticleInfoMapper.selectArticeBySiteIdPhone_page", param
				,new RowBounds(p.getCurrentResult(),p.getSize()));
	}


	@Override
	public void updateReadCount(String articleId) {
		int flag = getSqlSession().update("com.xiao.web.dao.ArticleInfoMapper.updateReadCountById", articleId);
		if(flag<=0)throw new RuntimeException("update article is error");
	}

	
}
