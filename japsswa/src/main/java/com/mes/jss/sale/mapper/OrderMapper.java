package com.mes.jss.sale.mapper;

import com.mes.jss.sale.domain.OrderVO;

public interface OrderMapper {

	public int insertOrder(OrderVO order);

	public int insertOrdDetail(OrderVO order);

}
