package com.mes.jss.sale.domain;

import java.util.List;

import lombok.Data;
@Data
public class SaleListVO {
	private List<OrderVO> list;
	private OrderVO commInfo;
	private String info;
}
