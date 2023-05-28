package com.mes.jss.material.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MrVO {              // 자재 vo
	 
	String mrLotNumber;
	String itemCode;
	long empNo; 
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date storeDate;
	long storeCount;
	long holdCount;
	@DateTimeFormat(pattern="YYYY-MM-dd")
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
	 
}
