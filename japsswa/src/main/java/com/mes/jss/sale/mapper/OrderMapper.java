package com.mes.jss.sale.mapper;

import java.util.List;

import com.mes.jss.sale.domain.OrderVO;
import com.mes.jss.sale.domain.SaleListVO;

public interface OrderMapper {

	List<OrderVO> custModalList();
	
	List<OrderVO> itemNamelist();

	List<OrderVO> custList(String custname);

	List<OrderVO> itemSearch(String code);
	
	List<OrderVO> custInfo(String customerId);
	
	public OrderVO entRegister(OrderVO commInfo);
	
	public OrderVO detRegister(OrderVO vo);

	List<OrderVO> custShowModal(String oCode);

	List<OrderVO> custOrdModal();

	List<OrderVO> orderShow(OrderVO orderVo);

	List<OrderVO> ordDetShow(String orderId);

	public void entDel(String delId);

	public void entDelDet(String delId);

	public void delDet(OrderVO vo);

	public void ordUpdate(OrderVO vo);

	//void delDet(String ordDetailId);

	








	

}
