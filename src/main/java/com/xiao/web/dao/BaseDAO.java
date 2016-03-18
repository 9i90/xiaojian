package com.xiao.web.dao;

import java.util.List;
import java.util.Map;

public interface BaseDAO {
	public void saveEntity(String sqMapId,Object entity);
	public List<Map> queryForList(String sqMapId,  Object queryParam);
	public Object selectOneObject(String sqMapId,  Object queryParam);
}
