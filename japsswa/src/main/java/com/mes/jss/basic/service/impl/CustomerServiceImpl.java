package com.mes.jss.basic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.mapper.CustomerMapper;
import com.mes.jss.basic.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	@Autowired CustomerMapper cusMapper;

}
