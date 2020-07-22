package com.couyis.txxcrm.customer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.couyis.common.util.UUIDUtil;
import com.couyis.common.web.bean.PageBean;
import com.couyis.txxcrm.customer.ICustomerService;
import com.couyis.txxcrm.customer.bean.CustomerBean;
import com.couyis.txxcrm.customer.dao.CustomerMapper;
import com.couyis.txxcrm.customer.pojo.Customer;

@Service
public class CustomerService implements ICustomerService {

	@Resource
	private CustomerMapper customerMapper;
	
	@Override
	@Transactional
	public void save(Customer t) {
		// TODO Auto-generated method stub
		t.setId(UUIDUtil.get());
		customerMapper.save(t);
	}

	@Override
	@Transactional
	public void update(Customer t) {
		// TODO Auto-generated method stub
		customerMapper.update(t);
	}

	@Override
	public Customer findById(String id) {
		// TODO Auto-generated method stub
		return customerMapper.findById(id);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		customerMapper.deleteById(id);
	}

	@Override
	public PageBean findPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setTotal(customerMapper.findCount((CustomerBean) pageBean));
		PageBean.calculate(pageBean);
		pageBean.setList(customerMapper.findPage((CustomerBean) pageBean));
		return pageBean;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerMapper.findAll();
	}

	@Override
	public Customer findByCode(String code) {
		// TODO Auto-generated method stub
		return customerMapper.findByCode(code);
	}

	@Override
	public List<Customer> findByName(String name) {
		// TODO Auto-generated method stub
		return customerMapper.findByName();
	}

	@Override
	public String findMaxCode() {
		// TODO Auto-generated method stub
		return customerMapper.findMaxCode();
	}

	@Override
	public String findCodeByUrl(String url) {
		// TODO Auto-generated method stub
		return customerMapper.findCodeByUrl(url);
	}

	@Override
	public String findStartCode(String code) {
		// TODO Auto-generated method stub
		return customerMapper.findStartCode(code);
	}

}
