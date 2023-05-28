package com.mes.jss.production.domain;

import java.util.Date;



import lombok.Data;

@Data
public class PerformanceVO {
	String performanceId;
	String wDetailId;
	String itemCode;
	String wBomId;
	String facCode;
	long outPut;
	long passItem;
	long failItem;
	
	Date startTime;
	
	Date endTime;
	String worker;
	
}
