package com.mes.jss.material.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MrAdjustmentVO {	// 자재 조정
	String adjustmentCode;
	String mrLotNumber;
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date registerDate;
	String process;
	long change;
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date adjustmentDate;
	long empNo;
	String itemCode;
	String itemName;
	long storeCount;
	long totalRel;
	long saveMaterial;
	String itemType;
	String admNote;
	Date mrAdDate1;
	Date mrAdDate2;
	String mrSearch;
}
