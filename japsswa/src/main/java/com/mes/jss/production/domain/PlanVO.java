package com.mes.jss.production.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PlanVO {
	
	String planId;
	String pdetailId;
	String planName;
	long empNo;
	String itemCode; 
	int planAmount; 
	int planPriority; 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date planStart;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date planEnd;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date planDate;
	int itemOrders;
	
	
	//	생산계획관리 페이지 :  제품 리스트
	String itemName;
	String itemType;
	
	// 생산계획 관리 페이지 : modal 계획 리스트
	String empName;
	
	String planCode;


	
}
