package com.xiao.web.dao;

import java.util.List;
import java.util.Map;
import com.xiao.web.entity.ArticleInfo;
import com.xiao.web.page.Page;

public interface ArticleInfoDao extends BaseDAO {
	ArticleInfo selectByPrimaryKey(String id);

	List<ArticleInfo> selectArticeByWhere(Map param, Page p);
	
	void updateReadCount(String articleId);
	
	List<Map>  queryArticleByWhere(Map param);
}
