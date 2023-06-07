package com.mes.jss.production.domain;

import lombok.Data;

@Data
public class PerformanceVO {
	String performanceId;
	String wdetailId;
	String itemCode;
	String wbomId;
	String facCode;
	long outPut;
	long passItem;
	long failItem;

	String startTime;
	String endTime;
	String worker;
	Long empNo;
	
	String proCode;
	String facName;
	String downReason;
	long workAmount;
	
	//등록시 작업시작 or 작업완료 여부
	String condition;
	
	
}
