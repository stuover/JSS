package com.mes.jss.sale.service;

import java.util.List;

import com.mes.jss.sale.domain.OrderVO;

public interface SaleService {
	
	List<OrderVO> itemNamelist();
	List<OrderVO> custList(String custname);
	
}
