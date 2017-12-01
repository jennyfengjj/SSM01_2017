package com.qst.service;

import com.qst.po.Customer;
import com.qst.util.Page;

public interface CustomerService {

	public Customer selectByNamePwd(String username,String password);
	
	public Page<Customer> selectCustomerList(Integer page,Integer size,String username,String gender,String startBirthday,String endBirthday);
	
}
