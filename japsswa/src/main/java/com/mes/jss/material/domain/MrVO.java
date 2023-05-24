package com.mes.jss.material.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrVO {              // 자재 vo
	 
	String mrLotNumber;
	String itemCode;
	long empNo; 
	Date storeDate;
	long storeCount;
	long holdCount;
	Date expireDate;
	String storeReasonType;
	String storeReasonCode;
	String testCode;
	String itemName;
	String itemType;
	String total;
	String empName;
	String saveMaterial;
	 
}
