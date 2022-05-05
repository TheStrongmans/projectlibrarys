package com.catering.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.catering.utils.DruidUtils;

public class BasicDao<T> {
	private QueryRunner qr = new QueryRunner();
	// 通用dml方法
	public int update(String sql,Object... parameters) {
		Connection connection = null;
		try {
			connection = DruidUtils.getConnection();
			int i = qr.update(connection,sql,parameters);
			return i;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			DruidUtils.close(null, null, connection);
		}
	}
	
	// 返回多个对象（即查询的结果是多行），针对任意表
	public List<T> queryMulti(String sql,Class<T> claszz,Object... parameters){
		Connection connection = null;
		try {
			connection = DruidUtils.getConnection();
			return qr.query(connection, sql,new BeanListHandler<T>(claszz),parameters);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			DruidUtils.close(null, null, connection);
		}
	}
	
	// 查询单行结果的通用方法
	public T queryStringle(String sql,Class<T> clazz,Object... parameters) {
		Connection connection = null;
		try {
			connection = DruidUtils.getConnection();
			return qr.query(connection,sql,new BeanHandler<T>(clazz),parameters);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			DruidUtils.close(null, null, connection);
		}
	}
	
	// 查询单行列的方法，返回单值的方法
	public Object queryScalar(String sql,Object... parameters) {
		Connection connection = null;
		try {
			connection = DruidUtils.getConnection();
			return qr.query(connection, sql,new ScalarHandler(),parameters);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			DruidUtils.close(null, null, connection);
		}
	}
}	
