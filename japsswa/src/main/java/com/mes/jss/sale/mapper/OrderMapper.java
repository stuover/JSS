package com.mes.jss.sale.mapper;

import java.util.List;

import com.mes.jss.sale.domain.OrderVO;

public interface OrderMapper {

	List<OrderVO> custModalList();
	
	List<OrderVO> itemNamelist();

	List<OrderVO> custList(String custname);

	List<OrderVO> itemSearch(String code);
	
	List<OrderVO> custInfo(String customerId);
	
	List<OrderVO> itemInfo(String itemCode);
	
	public OrderVO entRegister(OrderVO commInfo);
	
	public OrderVO detRegister(OrderVO vo);

	List<OrderVO> custShowModal(String oCode);

	List<OrderVO> custOrdModal();




	

}
