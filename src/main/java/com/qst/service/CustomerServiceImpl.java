package com.qst.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.qst.dao.CustomerMapper;
import com.qst.po.Customer;
import com.qst.util.Page;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	public Customer selectByNamePwd(String username, String password) {
		Customer customer = this.customerMapper.selectByNamePwd(username, password);
		return customer;
	}

	@Override
	public Page<Customer> selectCustomerList(Integer page, Integer rows,
			String username,String gender,String startBirthday,String endBirthday) {
		
		Customer customer = new Customer();
		if(!StringUtils.isEmpty(username))
			customer.setUsername(username);
		if(!StringUtils.isEmpty(gender))
			customer.setGender(gender);
		try {
			if(!StringUtils.isEmpty(startBirthday))
				customer.setStartBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(startBirthday));
			if(!StringUtils.isEmpty(endBirthday))
				customer.setEndBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(endBirthday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//������ʼ�к�
		customer.setStart((page-1)*rows);
		//���ò�ѯ��¼��
		customer.setRows(rows);
		//��ѯ��ǰҳ��¼
		List<Customer> list = customerMapper.selectCustomerList(customer);
		//��ȡ�ܼ�¼��
		Integer total = customerMapper.selectCustomerCount(customer);
		
		Page<Customer> result = new Page<>();
		result.setPage(page);
		result.setSize(rows);
		result.setTotal(total);
		result.setRows(list);
		
		return result;
	}

	
}
