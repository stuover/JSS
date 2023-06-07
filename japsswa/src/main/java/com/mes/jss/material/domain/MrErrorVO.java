package com.mes.jss.material.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MrErrorVO {	// 불량 자재
	String mrErrorCode;
	String mrLotNumber;
	String performanceId;
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date mrErrorDate;
	String mrErrorReason;
	long empNo;
	String mrRealCode;
	long errorCount;
	
	
	
}
