package com.mes.jss.sale.mapper;

import java.util.List;

import com.mes.jss.sale.domain.OrderVO;

public interface OrderMapper {

	List<OrderVO> itemNamelist();

	List<OrderVO> custList(String custname);

	

}
