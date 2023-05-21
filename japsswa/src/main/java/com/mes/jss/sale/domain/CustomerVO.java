package com.mes.jss.sale.domain;

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
	String contractId;
	String contProd;
	Date contDate;
}
