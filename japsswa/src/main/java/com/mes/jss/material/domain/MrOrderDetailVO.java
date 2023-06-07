package com.mes.jss.material.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MrOrderDetailVO {	// 자재 발주 상세
	 String mrOrderDetCode;
	 String mrOrderCode;
	 String itemCode;
	 String itemName;
	 long itemPrice;
	 String customerId;
	 String customerName;
	 long mrCount;
	 long mrPrice;
	 long priceTotal;
	 @DateTimeFormat(pattern="YYYY-MM-dd")
	 Date deliveryDate;
	 @DateTimeFormat(pattern="YYYY-MM-dd")
	 Date mrOrderDate;
	 String empName;
	 
	 
}
