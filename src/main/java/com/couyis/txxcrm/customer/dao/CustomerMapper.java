package com.couyis.txxcrm.customer.dao;

import java.util.List;

import com.couyis.txxcrm.customer.bean.CustomerBean;
import com.couyis.txxcrm.customer.pojo.Customer;


public interface CustomerMapper {

	Integer findCount(CustomerBean customerBean);

	List<Customer> findPage(CustomerBean customerBean);

	List<Customer> findAll();
	
	List<Customer> findByName();

	Customer findById(String id);

	Customer findByCode(String code);

	int deleteById(String id);

	int save(Customer customer);

	int update(Customer customer);
	
	String findMaxCode();
	
	String findCodeByUrl(String url);

	String findStartCode(String code);
}
