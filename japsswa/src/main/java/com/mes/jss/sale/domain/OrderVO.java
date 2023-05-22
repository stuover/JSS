package com.mes.jss.sale.domain;

import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {
	private String ordId;
	private String ordName;
	private int totalPrice;
	private String ordStatus;
	private String customerId;
	private Date ordDate;
	private Long empNo;
	
	private String ordDetailId;
	private int ordCount;
	private Date outDate;
	private String itemCode;
	private int unitPrice;
	private int eachPrice;
	
	private String customerName;
	private String custAddr;
	private String custMail;
	private String custTel;
	private String itemName;
	private String empName;

}
