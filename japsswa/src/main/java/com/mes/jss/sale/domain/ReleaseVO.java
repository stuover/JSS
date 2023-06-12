package com.mes.jss.sale.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReleaseVO {
	String fnReleaseId;
	long fnRelCount;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
	Date fnRelDate;
	String relDetailId;
	long relEachCount;

	
	//주문상세
	String ordDetailId;
	long ordCount;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
	Date outDate;
	String orddetStatus;
	
	//주문
	String ordId;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
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
	
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
	Date sDate;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
	Date eDate;
	String end;
	
}
