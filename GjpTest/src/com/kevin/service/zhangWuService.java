package com.kevin.service;

import java.util.List;

import com.kevin.dao.zhangwuDao;
import com.kevin.domain.zhangWu;


public class zhangWuService {
//Service ����zhangwuDao
	private zhangwuDao zhangwuDao = new zhangwuDao();
	/**
	 * ���巽�� ɾ������
	 * �������� ���ݸ�DAO�� 
	 * �������ݿ� ����DAO���е��� 
	 * ���Աλ�� ����DAO��Ķ���
	 */
	
	/**
	 *���巽�� ʵ������ɾ������
	 *�ɿ��Ʋ���� ��������ID
	 *����DAO���� ��������ID 
	 */
	public void deleteZhangHu(int zwid){
		zhangwuDao.deleteZhanghu(zwid);
	}
	/**
	 * ���巽�� ʵ������༭����
	 *  �ɿ��Ʋ���� �����˻�����
	 *  ����Dao�㷽�� ���� Zhangwu����
	 *  
	 */
	public void editZhangWu(zhangWu zw){
         zhangwuDao.editZhanghu(zw);
	}
	/**
	 * ���巽�� ʵ���������
	 * ���ɿ��Ʋ���ô��� zhangwu����
	 */
	public void addZhangWu(zhangWu zwid){
		zhangwuDao.addZhangWu(zwid);
	}
	/**
	 * ���巽�� ʵ�ֲ�ѯҵ��
	 * �������ɿ��Ʋ���� ����2�������ַ���
	 */
	public List<zhangWu> select(String startDate,String endDate){
		return zhangwuDao.select(startDate, endDate);
	}
	/**
	 * ���巽�� ʵ�����е���������
	 * �˷����ɿ��Ʋ���� 
	 * ȥ��dao �㷽�� ����zhangwu�����list����
	 */
	public List<zhangWu> selectAll(){
		return zhangwuDao.selectAll();
	}
}
