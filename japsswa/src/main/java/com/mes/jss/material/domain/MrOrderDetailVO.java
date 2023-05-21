package com.mes.jss.material.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrOrderDetailVO {	// 자재 발주 상세
	 String mrOrderDetail;
	 String mrOrderCode;
	 String itemCode;
	 String itemName;
	 String CustomerName;
	 long mrCount;
	 long mrPrice;
	 long priceTotal;
	 Date deliveryDate;
}
