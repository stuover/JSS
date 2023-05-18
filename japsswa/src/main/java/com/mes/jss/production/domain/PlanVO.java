package com.mes.jss.production.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date planDate;
	
	
	//	생산계획관리 페이지에서 제품별 주문정보 리스트
	String itemName;
	int ordCount;
	int ordSum;
	
	// 생산계획 관리 페이지 : modal 계획 리스트
	String empName;
	
	String planCode;


	
}
