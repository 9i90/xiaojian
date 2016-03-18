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
	public ArticleInfo selectByPrimaryKey(Integer id) {
		return getSqlSession().selectOne("com.idesky.crowdfund.server.dao.ArticleInfoDao.selectByPrimaryKey",id);
	}


	@Override
	public List selectArticeByWhere(Map param,Page p) {
//		int total = getSqlSession().selectOne("com.idesky.crowdfund.server.dao.ArticleInfoDao.selectArticeBySiteIdPhone_count", siteIds);
//		p.setTotal(total);
		return this.getSqlSession().selectList("com.idesky.crowdfund.server.dao.ArticleInfoDao.selectArticeBySiteIdPhone_page", param
				,new RowBounds(p.getCurrentResult(),p.getSize()));
	}

	
}
