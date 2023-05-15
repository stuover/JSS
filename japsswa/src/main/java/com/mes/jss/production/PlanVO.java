package com.mes.jss.production;

import java.util.Date;

import lombok.Data;

@Data
public class PlanVO {
	String planId;
	String pdetailId;
	String planName;
	int empNo;
	String itemCode; 
	int planAmount; 
	int planPriority; 
	Date planStart;
	Date planEnd;
	
}
