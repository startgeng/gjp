package com.kevin.controller;

import java.util.List;


import com.kevin.domain.zhangWu;
import com.kevin.service.zhangWuService;


public class ZhangWuController {
	private zhangWuService service = new zhangWuService();
//	 *  控制器层
//	 *  接收试图层的数据,数据传递给service层
//	 *  成员位置,创建service对象
//	 */
	
	/*
	 * 定义方法，实现删除功能
	 * 视图层调用，传递int类型主键
	 * 调用service层方法，传递int主键
	 */
	public void delectZhangWu(int zwid){
		service.deleteZhangHu(zwid);
	}
	/*
	 * 定义方法，实现编辑账务功能
	 * 由视图层调用，传递参数，也是ZhangWu对象
	 * 调用service层的方法，也是ZhangWu对象
	 */
	public void editZhangWu(zhangWu zw){
		service.editZhangWu(zw);
	}
	/*
	 * 定义方法，实现账务添加功能
	 * 由视图层调用，传递参数(传递过来的参数不能是5个数据，传递的是一个ZhangWu类型的对象)
	 * 本方法调用service层的方法，传递ZhangWu对象，获取到添加后的结果集(添加成功影响的行数，int)
	 * 
	 */
	public void addZhangWu(zhangWu zw){
		service.addZhangWu(zw);
	}
	/*
	 * 定义方法,实现条件查询账务
	 * 方法由试图层调用,传递两个日期的字符串
	 * 调用service层的方法,传递两个日期字符串,获取结果集
	 * 结果集返回给试图
	 */

	/*
	 * 控制层类定义方法,实现查询所有的账务数据
	 * 方法由试图层调用,方法调用service层
	 */
	public List<zhangWu> selectAll(){
		return service.selectAll();
	}
	public List<zhangWu> select(String startDate,String endDate){
		return service.select(startDate, endDate);
	}
}
