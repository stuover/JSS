package com.mes.jss.material.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrAdjustmentVO {	// 자재 조정
	String adjustmentCode;
	String mrLotNumber;
	Date registerDate;
	String process;
	long change;
	Date adjustmentDate;
	long empNo;
	String itemCode;
	String itemName;
	long storeCount;
	long totalRel;
	long saveMaterial;
	
}
