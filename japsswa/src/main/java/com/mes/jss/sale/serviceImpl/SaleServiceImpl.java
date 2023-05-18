package com.mes.jss.sale.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.sale.domain.OrderVO;
import com.mes.jss.sale.mapper.OrderMapper;
import com.mes.jss.sale.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {
	
	@Autowired OrderMapper orderMapper;

	@Override
	public boolean orderInsert(OrderVO order) {
		
		return orderMapper.insertOrder(order)==1;
	}

	@Override
	public boolean orddetailInsert(OrderVO order) {
		
		return orderMapper.insertOrdDetail(order)==1;
	}
	
	
}
