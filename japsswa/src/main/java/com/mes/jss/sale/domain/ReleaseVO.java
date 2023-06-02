package com.mes.jss.sale.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReleaseVO {
	String fnReleaseId;
	int fnRelCount;
	Date fnRelDate;

	
	//주문상세
	String ordDetailId;
	int ordCount;
	Date outDate;
	
	//주문
	String ordId;
	Date ordDate;
	String ordName;
	
	//품목
	String itemCode;
	String itemName;
	
	//거래처
	String customerId;
	String customerName;
	String custMail;
	String custAddr;
	String custTel;
	
	//사원
	int empNo;
	String empName;
	
	//완제품
	String fnLotNo;
	int fnCount;
	int remain;
	
}
