package com.kevin.view;


import java.util.List;
import java.util.Scanner;



import com.kevin.controller.ZhangWuController;

import com.kevin.domain.zhangWu;

public class MainView {
	private ZhangWuController zhangWuController = new ZhangWuController();
public void run(){
	/**
	 * 1. 打印菜单  2.获取数据 3.调取对应方法
	 */
	boolean flag = true;
	Scanner scanner = new Scanner(System.in);
	while(flag){
		System.out.println("-----------------------------管家婆记账软件------------------------");
		System.out.println("1.添加账务      2.编辑账务      3.删除账务          4.查询账务             5.退出系统");
		System.out.println("请输入要操作的功能序号1-5");
		int op = scanner.nextInt();
		switch (op) {
		case 1:
			addZhangWu();
			break;

		case 2:
			editZhangWu();
			break;
		case 3:
			deletezhangWu();
			break;
		case 4:
			SelectZhangWu();
			break;
		
		case 5:
			System.out.println("再见");
			flag =false;
			break;
			default:
				System.out.println("输入错误");
}}
}
public void deletezhangWu() {
	// TODO Auto-generated method stub
	selectAll();
	System.out.println("请输入要删除的ID");
	int zwid = new Scanner(System.in).nextInt();
    zhangWuController.delectZhangWu(zwid);
    System.out.println("删除账务成功");
}

public void SelectZhangWu() {
	// TODO Auto-generated method stub
	System.out.println("1. 查询所有     2.条件查询");
	Scanner scanner = new Scanner(System.in);
	int selectChooser = scanner.nextInt();
	switch (selectChooser) {
	case 1:
		selectAll();
		break;

	case 2:
		selectAll();
		break;
	}
}
public void editZhangWu() {
	// TODO Auto-generated method stub
	selectAll();
	System.out.println("选择的编辑功能,请输入数据");
	Scanner scanner = new Scanner(System.in);
	System.out.println("请输入ID");
	int zwid = scanner.nextInt();
	System.out.println("请输入分类名称");
	String flname = scanner.nextLine();
	System.out.println("输入金额");
	double money = scanner.nextDouble();
	System.out.println("输入账户");
	String zhanghu =scanner.nextLine();
	System.out.println("请输入日期格式为:xxxx-xx-x");
	String createtime = scanner.nextLine();
	System.out.println("请输入具体描述");
	String description = scanner.nextLine();
	zhangWu zw = new zhangWu(zwid, flname, money, zhanghu, createtime, description);
	zhangWuController.editZhangWu(zw);
	System.out.println("编辑账务成功");
}
public void selectAll(){
	 //调用控制层中的方法,查询所有的账务数据
	 List<zhangWu> list = zhangWuController.selectAll();
	 if(list.size()!=0)
		 print(list);
	 else
		 System.out.println("没有查询到数据");
}

private void print(List<zhangWu> list) {
	//输出表头
	 System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
	 //遍历集合,结果输出控制台
	 for(zhangWu zw : list){
		 System.out.println(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getZhanghu()+"\t\t"+
	     zw.getMoney()+"\t\t"+zw.getCreatetime()+"\t"+zw.getDescription());
	 }
}
public void addZhangWu() {
	// TODO Auto-generated method stub
	System.out.println("选择添加的账务功能,请输入以下内容");
	Scanner scanner = new Scanner(System.in);
	System.out.println("输入分类名称");
	String flname = scanner.nextLine();
	System.out.println("输入金额");
	double money = scanner.nextDouble();
	System.out.println("输入账户");
	String zhanghu = scanner.next();
	System.out.println("输入日期,格式为:xxxx-xx-x");
	String createtime = scanner.next();
	System.out.println("输入具体描述");
	String description = scanner.nextLine();
	//将账务中的数据调用controller 中的方法调用
	zhangWu zw = new zhangWu(0, flname, money, zhanghu, createtime, description);
    zhangWuController.addZhangWu(zw);
    System.out.println("账务添加成功");
}
/*
 * 定义方法,实现条件查询账务数据
 * 提供用户的输入日期,开始日期结束日期
 * 就2个日期,传递到controller层
 * 调用controller的方法,传递2个日期参数
 * 获取到controller查询的结果集,打印出来
 */
public void select(){
	 System.out.println("选择条件查询,输入日期格式XXXX-XX-XX");
	 Scanner sc = new Scanner(System.in);
	 System.out.print("请输入开始日期:");
	 String startDate = sc.nextLine();
	 System.out.print("请输入结果日期:");
	 String endDate = sc.nextLine();
	 //调用controller层的方法,传递日期,获取查询结果集
	 List<zhangWu> list = zhangWuController.select(startDate, endDate);
	 if(list.size()!=0)
		 print(list);
	 else
		 System.out.println("没有查询到数据");
}
}
