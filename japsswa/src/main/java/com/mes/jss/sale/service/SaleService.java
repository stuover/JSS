package com.mes.jss.sale.service;

import java.util.List;

import com.mes.jss.sale.domain.OrderVO;

public interface SaleService {
	
	List<OrderVO> custModalList();
	List<OrderVO> itemNamelist();
	List<OrderVO> custList(String custname);
	List<OrderVO> itemSearch(String code);
	List<OrderVO> custInfo(String customerId);
	List<OrderVO> itemInfo(String itemCode);
	public void entRegister(OrderVO commInfo, List<OrderVO> list);
	List<OrderVO> custShowModal(String oCode);
	List<OrderVO> custOrdModal();
	
}
