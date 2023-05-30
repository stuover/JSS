package com.mes.jss.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.domain.CustomerVO;
import com.mes.jss.basic.domain.TransListVO;
import com.mes.jss.basic.domain.TransactionItemVO;
import com.mes.jss.basic.mapper.CustomerMapper;
import com.mes.jss.basic.service.CustomerService;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired CustomerMapper cusMapper;

	@Override
	public List<CustomerVO> getList() {
		// TODO Auto-generated method stub
		return cusMapper.getCustomerList();
	}

	@Override
	public void saveCusDeta(TransListVO vo) {
		cusMapper.updateCus(vo.getDeta());
		
		for(TransactionItemVO list : vo.getList()) {
			
			list.setCustomerId(vo.getDeta().getCustomerId());
			
			if(list.getTransNo() == null ) {
				if(cusMapper.result(list) > 0) {
					continue;
				}else {
					cusMapper.insertTrans(list);

				}
			}
		}
		
		
	}

	@Override
	public List<TransactionItemVO> getTranList(String cusId) {
		// TODO Auto-generated method stub
		return cusMapper.getCusItemList(cusId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
