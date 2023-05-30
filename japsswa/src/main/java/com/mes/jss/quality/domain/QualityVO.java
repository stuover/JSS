package com.mes.jss.quality.domain;

import java.util.Date;

import lombok.Data;

@Data
public class QualityVO {	// 품질 VO
	String testCode;
	String itemCode;
	String mrOrderDetCode;
	String itemType;
	String situation;
	Date startDate;
	Date endDate;
	long empNo;
	String empName;
	double testQuantity;
	double errQuantity;
	
	long passQuantity;
	double defectiveRate;
	String testNote;
	double error;
	String itemName;
	
	
}
