package com.mes.jss.material.domain;





import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MrAdjustmentVO {	// 자재 조정
	String adjustmentCode;
	String mrLotNumber;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
	Date registerDate;
	String process;
	long change;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
	Date adjustmentDate;
	long empNo;
	String itemCode;
	String itemName;
	long storeCount;
	long totalRel;
	long saveMaterial;
	String itemType;
	String admNote;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
	Date mrAdDate1;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
	Date mrAdDate2;
	String mrSearch;
	String mrLot;
	
	
	
	
	
	
}
