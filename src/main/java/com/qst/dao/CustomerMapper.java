package com.qst.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qst.po.Customer;

public interface CustomerMapper {
	// �����û����������ѯ�û���Ϣ
	public Customer selectByNamePwd(@Param("username") String username,@Param("password") String password);
	// ��ѯ�ͻ��б�
    public List<Customer> selectCustomerList(Customer customer);
    // ��ѯ�ͻ���
    public Integer selectCustomerCount(Customer customer);
    
	int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Customer record);
}