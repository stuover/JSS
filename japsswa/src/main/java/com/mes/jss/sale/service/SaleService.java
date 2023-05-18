package com.mes.jss.sale.service;

import com.mes.jss.sale.domain.OrderVO;

public interface SaleService {
	
	public boolean orderInsert(OrderVO order);
	
	public boolean orddetailInsert(OrderVO order);
	
}
