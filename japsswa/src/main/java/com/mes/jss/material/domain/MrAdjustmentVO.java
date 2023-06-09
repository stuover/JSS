package com.mes.jss.material.domain;





import lombok.Data;

@Data
public class MrAdjustmentVO {	// 자재 조정
	String adjustmentCode;
	String mrLotNumber;
	
	String registerDate;
	String process;
	long change;
	
	String adjustmentDate;
	long empNo;
	String itemCode;
	String itemName;
	long storeCount;
	long totalRel;
	long saveMaterial;
	String itemType;
	String admNote;
	String mrAdDate1;
	String mrAdDate2;
	String mrSearch;
}
