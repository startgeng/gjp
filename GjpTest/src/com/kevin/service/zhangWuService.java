package com.kevin.service;

import java.util.List;

import com.kevin.dao.zhangwuDao;
import com.kevin.domain.zhangWu;


public class zhangWuService {
//Service 依赖zhangwuDao
	private zhangwuDao zhangwuDao = new zhangwuDao();
	/**
	 * 定义方法 删除功能
	 * 经过计算 传递给DAO层 
	 * 操作数据库 调用DAO层中的类 
	 * 类成员位置 创建DAO类的对象
	 */
	
	/**
	 *定义方法 实现账务删除功能
	 *由控制层调用 传递主键ID
	 *调用DAO方法 传递主键ID 
	 */
	public void deleteZhangHu(int zwid){
		zhangwuDao.deleteZhanghu(zwid);
	}
	/**
	 * 定义方法 实现账务编辑功能
	 *  由控制层调用 传递账户对象
	 *  调用Dao层方法 传递 Zhangwu对象
	 *  
	 */
	public void editZhangWu(zhangWu zw){
         zhangwuDao.editZhanghu(zw);
	}
	/**
	 * 定义方法 实现添加账务
	 * 是由控制层调用传递 zhangwu对象
	 */
	public void addZhangWu(zhangWu zwid){
		zhangwuDao.addZhangWu(zwid);
	}
	/**
	 * 定义方法 实现查询业务
	 * 方法是由控制层调用 传递2个日期字符串
	 */
	public List<zhangWu> select(String startDate,String endDate){
		return zhangwuDao.select(startDate, endDate);
	}
	/**
	 * 定义方法 实现所有的账务数据
	 * 此方法由控制层调用 
	 * 去掉dao 层方法 反会zhangwu对象的list集合
	 */
	public List<zhangWu> selectAll(){
		return zhangwuDao.selectAll();
	}
}
