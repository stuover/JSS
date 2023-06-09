package com.mes.jss.material.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MrVO {              // 자재 vo
	 
	String mrLotNumber;
	String itemCode;
	long empNo; 
	
	String storeDate;
	long storeCount;
	long holdCount;
	
	String expireDate;
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
	String storeDate1;
	String storeDate2;
	String mrSearch;
	 
}
