package com.mes.jss.sale.domain;

import java.util.List;

import lombok.Data;
@Data
public class SaleListVO {
	List<OrderVO> list;
	String code;
}
