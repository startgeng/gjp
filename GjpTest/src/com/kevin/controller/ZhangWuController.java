package com.kevin.controller;

import java.util.List;


import com.kevin.domain.zhangWu;
import com.kevin.service.zhangWuService;


public class ZhangWuController {
	private zhangWuService service = new zhangWuService();
//	 *  ��������
//	 *  ������ͼ�������,���ݴ��ݸ�service��
//	 *  ��Աλ��,����service����
//	 */
	
	/*
	 * ���巽����ʵ��ɾ������
	 * ��ͼ����ã�����int��������
	 * ����service�㷽��������int����
	 */
	public void delectZhangWu(int zwid){
		service.deleteZhangHu(zwid);
	}
	/*
	 * ���巽����ʵ�ֱ༭������
	 * ����ͼ����ã����ݲ�����Ҳ��ZhangWu����
	 * ����service��ķ�����Ҳ��ZhangWu����
	 */
	public void editZhangWu(zhangWu zw){
		service.editZhangWu(zw);
	}
	/*
	 * ���巽����ʵ��������ӹ���
	 * ����ͼ����ã����ݲ���(���ݹ����Ĳ���������5�����ݣ����ݵ���һ��ZhangWu���͵Ķ���)
	 * ����������service��ķ���������ZhangWu���󣬻�ȡ����Ӻ�Ľ����(��ӳɹ�Ӱ���������int)
	 * 
	 */
	public void addZhangWu(zhangWu zw){
		service.addZhangWu(zw);
	}
	/*
	 * ���巽��,ʵ��������ѯ����
	 * ��������ͼ�����,�����������ڵ��ַ���
	 * ����service��ķ���,�������������ַ���,��ȡ�����
	 * ��������ظ���ͼ
	 */

	/*
	 * ���Ʋ��ඨ�巽��,ʵ�ֲ�ѯ���е���������
	 * ��������ͼ�����,��������service��
	 */
	public List<zhangWu> selectAll(){
		return service.selectAll();
	}
	public List<zhangWu> select(String startDate,String endDate){
		return service.select(startDate, endDate);
	}
}
