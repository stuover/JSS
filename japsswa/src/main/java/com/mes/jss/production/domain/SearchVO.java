package com.mes.jss.production.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SearchVO {
	
	String startTime;
	
	String endTime;
	PlanVO result;
}
