package com.xiao.web.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.xiao.web.dao.BaseDAO;

public class BaseDaoImpl extends SqlSessionDaoSupport implements BaseDAO {
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
	    super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<Map> queryForList(String sqMapId, Object queryParam) {
		return getSqlSession().selectList(sqMapId, queryParam);
	}

	@Override
	public Object selectOneObject(String sqMapId, Object queryParam) {
		return getSqlSession().selectOne(sqMapId, queryParam);
	}

	@Override
	public void saveEntity(String sqMapId, Object entity) {
		int flag = getSqlSession().insert(sqMapId, entity);
		if(flag<=0)throw new RuntimeException("insert entity is error");
	}
	

}
