package com.xiao.web.dao;

import java.util.List;
import java.util.Map;
import com.xiao.web.entity.ArticleInfo;
import com.xiao.web.page.Page;

public interface ArticleInfoDao extends BaseDAO {
	ArticleInfo selectByPrimaryKey(Integer id);

	List<ArticleInfo> selectArticeByWhere(Map param, Page p);
}
