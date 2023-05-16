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
	
//	생산계획관리 페이지에서 제품별 주문정보 리스트
	String itemName;
	int ordCount;
	
}
