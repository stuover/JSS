package com.mes.jss.sale.service;

import java.util.List;

import com.mes.jss.sale.domain.OrderVO;
import com.mes.jss.sale.domain.SaleListVO;

public interface SaleService {
	
	List<OrderVO> custModalList();
	List<OrderVO> itemNamelist();
	List<OrderVO> custList(String custname);
	List<OrderVO> itemSearch(String code);
	List<OrderVO> custInfo(String customerId);
	public void entRegister(OrderVO commInfo, List<OrderVO> list);
	List<OrderVO> custShowModal(String oCode);
	List<OrderVO> custOrdModal();
	List<OrderVO> orderShow(OrderVO orderVo);
	List<OrderVO> ordDetShow(String orderId);
	public void entDel(String delId);
	//List<OrderVO> delDet(SaleListVO svo);
	public void delDet(List<OrderVO> list);
	public void ordUpdate(SaleListVO slist);

	
}
