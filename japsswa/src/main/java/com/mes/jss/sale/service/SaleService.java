package com.mes.jss.sale.service;

import java.util.List;

import com.mes.jss.sale.domain.OrderVO;
import com.mes.jss.sale.domain.SaleListVO;

public interface SaleService {
	
	List<OrderVO> itemNamelist();
	List<OrderVO> custList(String custname);
	List<SaleListVO> entRegister(SaleListVO listVo);
	
}
