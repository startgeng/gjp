package com.kevin.view;


import java.util.List;
import java.util.Scanner;



import com.kevin.controller.ZhangWuController;

import com.kevin.domain.zhangWu;

public class MainView {
	private ZhangWuController zhangWuController = new ZhangWuController();
public void run(){
	/**
	 * 1. ��ӡ�˵�  2.��ȡ���� 3.��ȡ��Ӧ����
	 */
	boolean flag = true;
	Scanner scanner = new Scanner(System.in);
	while(flag){
		System.out.println("-----------------------------�ܼ��ż������------------------------");
		System.out.println("1.�������      2.�༭����      3.ɾ������          4.��ѯ����             5.�˳�ϵͳ");
		System.out.println("������Ҫ�����Ĺ������1-5");
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
			System.out.println("�ټ�");
			flag =false;
			break;
			default:
				System.out.println("�������");
}}
}
public void deletezhangWu() {
	// TODO Auto-generated method stub
	selectAll();
	System.out.println("������Ҫɾ����ID");
	int zwid = new Scanner(System.in).nextInt();
    zhangWuController.delectZhangWu(zwid);
    System.out.println("ɾ������ɹ�");
}

public void SelectZhangWu() {
	// TODO Auto-generated method stub
	System.out.println("1. ��ѯ����     2.������ѯ");
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
	System.out.println("ѡ��ı༭����,����������");
	Scanner scanner = new Scanner(System.in);
	System.out.println("������ID");
	int zwid = scanner.nextInt();
	System.out.println("�������������");
	String flname = scanner.nextLine();
	System.out.println("������");
	double money = scanner.nextDouble();
	System.out.println("�����˻�");
	String zhanghu =scanner.nextLine();
	System.out.println("���������ڸ�ʽΪ:xxxx-xx-x");
	String createtime = scanner.nextLine();
	System.out.println("�������������");
	String description = scanner.nextLine();
	zhangWu zw = new zhangWu(zwid, flname, money, zhanghu, createtime, description);
	zhangWuController.editZhangWu(zw);
	System.out.println("�༭����ɹ�");
}
public void selectAll(){
	 //���ÿ��Ʋ��еķ���,��ѯ���е���������
	 List<zhangWu> list = zhangWuController.selectAll();
	 if(list.size()!=0)
		 print(list);
	 else
		 System.out.println("û�в�ѯ������");
}

private void print(List<zhangWu> list) {
	//�����ͷ
	 System.out.println("ID\t\t���\t\t�˻�\t\t���\t\tʱ��\t\t˵��");
	 //��������,����������̨
	 for(zhangWu zw : list){
		 System.out.println(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getZhanghu()+"\t\t"+
	     zw.getMoney()+"\t\t"+zw.getCreatetime()+"\t"+zw.getDescription());
	 }
}
public void addZhangWu() {
	// TODO Auto-generated method stub
	System.out.println("ѡ����ӵ�������,��������������");
	Scanner scanner = new Scanner(System.in);
	System.out.println("�����������");
	String flname = scanner.nextLine();
	System.out.println("������");
	double money = scanner.nextDouble();
	System.out.println("�����˻�");
	String zhanghu = scanner.next();
	System.out.println("��������,��ʽΪ:xxxx-xx-x");
	String createtime = scanner.next();
	System.out.println("�����������");
	String description = scanner.nextLine();
	//�������е����ݵ���controller �еķ�������
	zhangWu zw = new zhangWu(0, flname, money, zhanghu, createtime, description);
    zhangWuController.addZhangWu(zw);
    System.out.println("������ӳɹ�");
}
/*
 * ���巽��,ʵ��������ѯ��������
 * �ṩ�û�����������,��ʼ���ڽ�������
 * ��2������,���ݵ�controller��
 * ����controller�ķ���,����2�����ڲ���
 * ��ȡ��controller��ѯ�Ľ����,��ӡ����
 */
public void select(){
	 System.out.println("ѡ��������ѯ,�������ڸ�ʽXXXX-XX-XX");
	 Scanner sc = new Scanner(System.in);
	 System.out.print("�����뿪ʼ����:");
	 String startDate = sc.nextLine();
	 System.out.print("������������:");
	 String endDate = sc.nextLine();
	 //����controller��ķ���,��������,��ȡ��ѯ�����
	 List<zhangWu> list = zhangWuController.select(startDate, endDate);
	 if(list.size()!=0)
		 print(list);
	 else
		 System.out.println("û�в�ѯ������");
}
}
