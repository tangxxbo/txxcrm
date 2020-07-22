package com.couyis.txxcrm.customer.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.couyis.base.codedis.ICodeRangeDisService;
import com.couyis.common.web.bean.PageBean;
import com.couyis.common.web.controller.BaseController;
import com.couyis.txxcrm.customer.ICustomerService;
import com.couyis.txxcrm.customer.bean.CustomerBean;
import com.couyis.txxcrm.customer.pojo.Customer;

@RestController
@RequestMapping("/base/customer")
public class CustomerController extends BaseController{
	
	@Resource
	private ICustomerService customerService;
	
	
	@RequestMapping(value = "/add")
	public void save(Customer customer,HttpServletRequest request) {
		customer.setCode(cusCode(request.getServletPath().toString()));
		customer.setCreateUser(getAccount(request));
		customer.setCreateTime(getNow());
		customerService.save(customer);
	}
	
	@RequestMapping(value = "/list")
	public PageBean list(@RequestBody CustomerBean pageBean) {
		return customerService.findPage(pageBean);
	}
	
	@RequestMapping(value = "/findAll")
	public List<Customer> findAll() {
		
		return customerService.findAll();
	}
	
	/**
	 * 通过URL获取号码段分配的内容，然后通过号码段编码去获取起始编码
	 * @param url
	 * @return
	 */
	public String cusCode(String url) {
		Integer cusCode;
		if(findAll().size() != 0 || !findAll().isEmpty()) {
			cusCode = Integer.valueOf(customerService.findMaxCode());
			++cusCode ;
			return cusCode.toString();
		}
		if(isCode(url) !=true){
			return customerService.findStartCode(customerService.findCodeByUrl(url));
		}
		return null;
	}
	
	@RequestMapping(value = "/findCodeRangeDis")
	public Boolean isCode(String url) {
		String code = customerService.findCodeByUrl(url);
		if(code==null && !"".equals(code)) {
			return true;
		}
		return false;
	}
}
