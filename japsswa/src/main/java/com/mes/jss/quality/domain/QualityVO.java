package com.mes.jss.quality.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class QualityVO {	// 품질 VO
	String testCode;
	String itemCode;
	String mrOrderDetCode;
	String itemType;
	String situation;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	Date startDate;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	Date endDate;
	long empNo;
	String empName;
	BigDecimal testQuantity;
	BigDecimal errQuantity;
	
	long passQuantity;
	double defectiveRate;
	String testNote;
	double error;
	String itemName;
	long EmpNo2;
	
	
}
