package com.qst.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qst.po.Customer;

public interface CustomerMapper {
	// 根据用户名和密码查询用户信息
	public Customer selectByNamePwd(@Param("username") String username,@Param("password") String password);
	// 查询客户列表
    public List<Customer> selectCustomerList(Customer customer);
    // 查询客户数
    public Integer selectCustomerCount(Customer customer);
    
	int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Customer record);
}