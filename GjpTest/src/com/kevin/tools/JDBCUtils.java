package com.kevin.tools;



import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
    //����BasicDataSource����
	private static BasicDataSource datasource = new BasicDataSource();
	//��̬�����,ʵ�ֱ�Ҫ��������
	static{
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/gjp");
		datasource.setUsername("root");
		datasource.setPassword("123");
		datasource.setMaxActive(10);
		datasource.setMaxIdle(5);
		datasource.setMinIdle(2);
		datasource.setInitialSize(10);
	}
	public static DataSource getDataSource(){
		return datasource;
	}
}
