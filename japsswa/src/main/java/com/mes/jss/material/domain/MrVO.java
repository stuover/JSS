package com.mes.jss.material.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MrVO {              // 자재 vo
	 
	String mrLotNumber;
	String itemCode;
	long empNo; 
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	Date storeDate;
	long storeCount;
	long holdCount;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	Date expireDate;
	String storeReasonType;
	String storeReasonCode;
	String testCode;
	String itemName;
	String itemType;
	String total;
	String empName;
	String saveMaterial;
	String performanceId;
	String passItem;
	String customerId;
	String customerName;
	String itemPrice;
	String mrType;
	String searchText;
	String Name;
	
	String mrRealReasonType;
	String store;
	String material;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
	Date storeDate1;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
	Date storeDate2;
	String mrSearch;
	
	String div;
	 
}
