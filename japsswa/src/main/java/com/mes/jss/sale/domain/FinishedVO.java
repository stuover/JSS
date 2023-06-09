package com.mes.jss.sale.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class FinishedVO {
	 String fnLotNo;
	 long fnCount;
	 @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	 @DateTimeFormat(pattern="YYYY-MM-dd" )
	 Date fnStoreIn;
	 @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	 @DateTimeFormat(pattern="YYYY-MM-dd" )
	 Date fnExpiration;
	 String itemCode;
	 String itemName;
	 long empNo;
	 String empName;
	 String performanceId;
	 String endTime;
	 long passItem;
	 String orddetStatus;
	 String worker;
	 String perStatus;
	 String inDate1;
	 String inDate2;
	
}
