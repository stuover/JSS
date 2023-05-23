package com.mes.jss.sale.domain;

import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {
	private String ordId;
	private String ordName;
	private long totalPrice;
	private String ordStatus;
	private String customerId;
	private Date ordDate;
	private Long empNo;
	
	private String ordDetailId;
	private long ordCount;
	private Date outDate;
	private String itemCode;
	private long unitPrice;
	private long eachPrice;
	
	private String customerName;
	private String custAddr;
	private String custMail;
	private String custTel;
	private String itemName;
	private String empName;

}
