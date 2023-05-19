package com.mes.jss.sale.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.sale.domain.OrderVO;
import com.mes.jss.sale.mapper.OrderMapper;
import com.mes.jss.sale.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {
	
	@Autowired OrderMapper orderMapper;

	@Override
	public List<OrderVO> itemNamelist() {
		List<OrderVO> list = new ArrayList<>();
		list = orderMapper.itemNamelist();
		
		return list;
	}

	@Override
	public List<OrderVO> custList(String custname) {
		List<OrderVO> clist = orderMapper.custList(custname);
		
		return clist;
	}

	
	
}
