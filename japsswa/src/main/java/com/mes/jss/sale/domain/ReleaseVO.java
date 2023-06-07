package com.mes.jss.sale.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReleaseVO {
	String fnReleaseId;
	long fnRelCount;
	Date fnRelDate;
	String relDetailId;
	long relEachCount;

	
	//주문상세
	String ordDetailId;
	long ordCount;
	Date outDate;
	String orddetStatus;
	
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
	long empNo;
	String empName;
	
	//완제품
	String fnLotNo;
	long fnCount;
	long remain;
	
}
