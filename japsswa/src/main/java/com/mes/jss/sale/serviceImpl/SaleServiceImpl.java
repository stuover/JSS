package com.mes.jss.sale.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.sale.domain.OrderVO;
import com.mes.jss.sale.domain.SaleListVO;
import com.mes.jss.sale.mapper.OrderMapper;
import com.mes.jss.sale.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {
	
	@Autowired OrderMapper orderMapper;
	
	@Override
	public List<OrderVO> custModalList() {
		List<OrderVO> iList = orderMapper.custModalList();
		return iList;
	}

	@Override
	public List<OrderVO> itemNamelist() {
		List<OrderVO> list = orderMapper.itemNamelist();
		
		return list;
	}

	@Override
	public List<OrderVO> custList(String custname) {
		List<OrderVO> clist = orderMapper.custList(custname);
		
		return clist;
	}

	@Override
	public List<OrderVO> itemSearch(String code) {
		List<OrderVO> iSearch = orderMapper.itemSearch(code);
		
		return iSearch;
	}
	
	@Override
	public List<OrderVO> custInfo(String customerId) {
		List<OrderVO> cInfo = orderMapper.custInfo(customerId);
		return cInfo;
	}
	
	@Override
	public void entRegister(OrderVO commInfo, List<OrderVO> list) {
		 orderMapper.entRegister(commInfo);
		
		 for(OrderVO Ovo : list) { 
		 Ovo.setCustomerId(commInfo.getCustomerId());
		 orderMapper.detRegister(Ovo); }
		 
		
	}

	@Override
	public List<OrderVO> custShowModal(String oCode) {
		List<OrderVO> showList = orderMapper.custShowModal(oCode);
		return showList;
	}

	@Override
	public List<OrderVO> custOrdModal() {
		List<OrderVO> ordModal = orderMapper.custOrdModal();
		return ordModal;
	}

	@Override
	public List<OrderVO> orderShow(OrderVO orderVo) {
		List<OrderVO> ordList = orderMapper.orderShow(orderVo);
		return ordList;
	}

	@Override
	public List<OrderVO> ordDetShow(String orderId) {
		List<OrderVO> odList = orderMapper.ordDetShow(orderId);
		return odList;
	}

	@Override
	public void entDel(String delId) {
		orderMapper.entDelDet(delId);
		orderMapper.entDel(delId);
		
		
	}

	@Override
	public void delDet(List<OrderVO> list) {
		for(OrderVO vo : list) {
			orderMapper.delDet(vo);
		}
		
	}



	@Override
	public void ordUpdate(SaleListVO slist) {
		
		for(OrderVO vo : slist.getList()) {
			vo.setOrdId(slist.getInfo());
			System.err.println(vo);

			orderMapper.ordUpdate(vo);

		}
		
	}

	@Override
	public List<OrderVO> entOrderList() {
		List<OrderVO> entList = orderMapper.entOrderList();
		return entList;
	}

	@Override
	public List<OrderVO> orderCheck(OrderVO cvo) {
		List<OrderVO> chList = orderMapper.orderCheck();
		return chList;
	}

	@Override
	public List<OrderVO> detCheck(String ordId) {
		List<OrderVO> dList = orderMapper.detCheck(ordId); 
		return dList;
	}


	




	
	
}
