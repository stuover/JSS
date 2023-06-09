package com.mes.jss.sale.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrderVO {
	private String ordId;
	private String ordName;
	private long totalPrice;
	private String customerId;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
	private Date ordDate;
	private Long empNo;
	
	private String ordDetailId;
	private long ordCount;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
	private Date outDate;
	private String itemCode;
	private long unitPrice;
	private long eachPrice;
	private String ordDetStatus;
	
	private String customerName;
	private String custAddr;
	private String custMail;
	private String custTel;
	private String itemName;
	private String empName;
	private String sOrdDate;
	private String eOrdDate;
}
