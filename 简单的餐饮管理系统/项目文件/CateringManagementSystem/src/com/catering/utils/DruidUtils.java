package com.catering.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
/**
 * druicd德鲁伊数据库连接池工具类
 * @author stephen
 *
 */
public class DruidUtils {
	private static DataSource ds;
	// 初始化ds
	static {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src\\druid.properties"));
			ds = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 编写getConnection 方法
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	// 关闭连接，在数据库连接池技术中，close 不是真的断掉连接
	// 而是把使用的Connection 对象放回连接池
	public static void close(ResultSet set,Statement statement,Connection connection) {
		try {
			if(set!=null)set.close();
			if(statement!=null)statement.close();
			if(connection!=null)connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
