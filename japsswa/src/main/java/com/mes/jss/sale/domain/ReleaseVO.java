package com.mes.jss.sale.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReleaseVO {
	String releaseId;
	int relCount;
	Date relDate;
	String lotNo;
	
	//주문상세
	String ordDetailId;
	int ordCount;
	Date outDate;
	
	//주문
	String ordId;
	Date ordDate;
	
	//품목
	String itemCode;
	String itemName;
	
	//거래처
	String customerId;
	String customerName;
	
	//사원
	int empNo;
}
