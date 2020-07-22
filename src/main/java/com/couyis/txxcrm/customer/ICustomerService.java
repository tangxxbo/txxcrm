package com.couyis.txxcrm.customer;

import java.util.List;

import com.couyis.common.web.IService;
import com.couyis.txxcrm.customer.pojo.Customer;

public interface ICustomerService extends IService<Customer> {

	public List<Customer> findAll();
	public Customer findById(String id);
	public Customer findByCode(String code);
	public List<Customer> findByName(String name);
	public String findMaxCode();
	public String findCodeByUrl(String url);
	public String findStartCode(String code);
//	public Customer findBy();
}
