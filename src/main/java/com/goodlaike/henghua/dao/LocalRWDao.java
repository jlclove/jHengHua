package com.goodlaike.henghua.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import com.goodlaike.framework.dao.support.BaseRWDao;

/**
 * 本地读写 dao
 * 
 * @author jail
 */
public abstract class LocalRWDao<T> extends BaseRWDao<T> {

	@Resource(name = "goodlaikeHenghuaSqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
