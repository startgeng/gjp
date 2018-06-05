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
 * ���巽�� 
 * ʵ��ɾ��ҵ��ҵ������
 * ��������ID
 */
public void deleteZhanghu(int zwid){
	//ƴдSQL
	String sql = "Delete from gjp_zhangwu WHERE zwid=?";
	try {
		
		queryRunner.update(sql,zwid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
		throw new RuntimeException("ɾ������ʧ��");
	}
}
public void editZhanghu(zhangWu zw){
	String sql = "UPDATE gjp_zhanwhu set flname=?,money=?,zhanghu=?,createtime=?,description=?,WHERE zwid=?";
	//������������װ��������
	Object[] params = {zw.getCreatetime(),zw.getDescription(),zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getZwid()};
	//����qr ִ��
	 try {
		queryRunner.update(sql,params);
	} catch (SQLException e) {
		System.out.println(e);
		// TODO Auto-generated catch block
		throw new RuntimeException("�༭����ʧ��");
	}
}
/**
 * ���巽��ʵ�����������
 * ��ҵ�����ô����˻�����
 * ���˻��е�������ӵ����ݿ���
 * @param zw
 */
public void addZhangWu(zhangWu zw) {
	try{
		 //ƴ��������ݵ�sql
		String sql = "INSERT INTO gjp_zhangwu (flname,money,zhanghu,createtime,description) VALUES(?,?,?,?,?)";
		//�����������飬����5��ռλ����ʵ�ʲ���
		//ʵ�ʲ�����Դ�Ǵ��ݹ����Ķ���ZhangWu
		Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
		//����qr�����еķ���updateִ�����
		queryRunner.update(sql, params);
	}catch(SQLException ex) {
		System.out.println(ex);
		throw new RuntimeException("�������ʧ��");
	}
}
	
/**
//	/*
//	 * ���巽��,��ѯ���ݿ�,��������ȥ��ѯ�����
//	 * ��ҵ������,��ѯ������洢��Bean����,�洢��List����
//	 * �����ߴ���2�������ַ���
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
		throw new RuntimeException("������ѯʧ��");
	}

}
/**
 * 
	 * ���巽��,��ѯ���ݿ�,��ȡ���е���������
//	 * ����,��ҵ������
//	 * �����,�����е���������,�洢��Bean������,�洢��������
//	 */
public List<zhangWu> selectAll(){
	 
	 try {
		 String sql = "SELECT * FROM gjp_zhangwu";
		List<zhangWu> list = queryRunner.query(sql, new BeanListHandler<>(zhangWu.class));
		return list;
	} catch (SQLException e) {
		System.out.println(e);
	    throw new RuntimeException("��ѯ���е�����ʧ��");
	}
} 
}
