package com.mes.jss.basic.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerVO {
	String customerId;
	String customerName;
	String custAddr;
	String custMail;
	String custTel;
	String custPart;
	String contractStatus;
	String custEtc;
	
	int empNo;
	String itemName;
	String itemCode;
	long itemPrice;
	
	String contractId;
	String contProd;
	Date contDate;
	long mrPrice;
	
	String div;
	
}
