package com.mes.jss.production.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date startTime;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date endTime;
	Long empNo;
	
	
	
	
	
}
