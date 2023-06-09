package com.mes.jss.production.domain;

import lombok.Data;

@Data
public class PerformanceVO {
	String performanceId;
	String wdetailId;
	String itemCode;
	String itemName;
	String wbomId;
	String facCode;
	long output;
	long passItem;
	long failItem;

	String startTime;
	String endTime;
	String worker;
	Long empNo;
	
	String proCode;
	String proName;
	String facName;
	String downReason;
	long workAmount;
	String facStatus;
	String detaName;
	
	//등록시 작업시작 or 작업완료 여부
	String condition;
	
	
}
