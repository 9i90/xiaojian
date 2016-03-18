package com.xiao.web.dao;

import java.util.List;
import java.util.Map;

public interface BaseDAO {
	public List<Map> queryForList(String sqMapId,  Object queryParam);
	public Object selectOneObject(String sqMapId,  Object queryParam);
}
