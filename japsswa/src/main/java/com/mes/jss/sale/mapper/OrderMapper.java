package com.mes.jss.sale.mapper;

import java.util.List;

import com.mes.jss.sale.domain.OrderVO;
import com.mes.jss.sale.domain.SaleListVO;

public interface OrderMapper {

	List<OrderVO> itemNamelist();

	List<OrderVO> custList(String custname);

	List<SaleListVO> entRegister(SaleListVO listVo);

	

}
