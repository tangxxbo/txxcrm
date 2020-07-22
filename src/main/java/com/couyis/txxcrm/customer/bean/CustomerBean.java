package com.couyis.txxcrm.customer.bean;

import com.couyis.common.web.bean.PageBean;

public class CustomerBean extends PageBean {
	
	private String code;
	
	private String name;
	
	

	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String fieldConvert(String field) {
		// TODO Auto-generated method stub
		return null;
	}

}
