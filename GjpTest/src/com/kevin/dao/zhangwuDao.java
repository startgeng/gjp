package com.kevin.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.zip.ZipEntry;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.kevin.domain.zhangWu;
import com.kevin.tools.JDBCUtils;



public class zhangwuDao {
private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
/**
 * 定义方法 
 * 实现删除业务，业务层调用
 * 传递主键ID
 */
public void deleteZhanghu(int zwid){
	//拼写SQL
	String sql = "Delete from gjp_zhangwu WHERE zwid=?";
	try {
		
		queryRunner.update(sql,zwid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
		throw new RuntimeException("删除账务失败");
	}
}
public void editZhanghu(zhangWu zw){
	String sql = "UPDATE gjp_zhanwhu set flname=?,money=?,zhanghu=?,createtime=?,description=?,WHERE zwid=?";
	//定义对象数组封装所有数据
	Object[] params = {zw.getCreatetime(),zw.getDescription(),zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getZwid()};
	//调用qr 执行
	 try {
		queryRunner.update(sql,params);
	} catch (SQLException e) {
		System.out.println(e);
		// TODO Auto-generated catch block
		throw new RuntimeException("编辑账务失败");
	}
}
/**
 * 定义方法实现添加账务功能
 * 由业务层调用传递账户对象
 * 将账户中的数据添加到数据库中
 * @param zw
 */
public void addZhangWu(zhangWu zw) {
	try{
		 //拼接添加数据的sql
		String sql = "INSERT INTO gjp_zhangwu (flname,money,zhanghu,createtime,description) VALUES(?,?,?,?,?)";
		//创建对象数组，处处5个占位符的实际参数
		//实际参数来源是传递过来的对象ZhangWu
		Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
		//调用qr对象中的方法update执行添加
		queryRunner.update(sql, params);
	}catch(SQLException ex) {
		System.out.println(ex);
		throw new RuntimeException("账务添加失败");
	}
}
	
/**
//	/*
//	 * 定义方法,查询数据库,带有条件去查询账务表
//	 * 由业务层调用,查询结果集存储到Bean对象,存储到List集合
//	 * 调用者传递2个日期字符串
 */
 

public List<zhangWu> select(String startDate,String endDate){
	
	try {
		String sql = "SELECT * from gjp_zhangwu WHERE BETWEEN ? AND?";
		Object[] params = {startDate,endDate};
		queryRunner.update(sql,params);

		return queryRunner.query(sql, new BeanListHandler<>(zhangWu.class),params);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
		throw new RuntimeException("条件查询失败");
	}

}
/**
 * 
	 * 定义方法,查询数据库,获取所有的账务数据
//	 * 方法,由业务层调用
//	 * 结果集,将所有的账务数据,存储到Bean对象中,存储到集合中
//	 */
public List<zhangWu> selectAll(){
	 
	 try {
		 String sql = "SELECT * FROM gjp_zhangwu";
		List<zhangWu> list = queryRunner.query(sql, new BeanListHandler<>(zhangWu.class));
		return list;
	} catch (SQLException e) {
		System.out.println(e);
	    throw new RuntimeException("查询所有的账务失败");
	}
} 
}
