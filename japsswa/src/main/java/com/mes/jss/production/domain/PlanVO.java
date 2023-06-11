package com.mes.jss.production.domain;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PlanVO {
	
	String planId;
	String pdetailId;
	String planName;
	long empNo;
	String itemCode; 
	long planAmount; 
	int planPriority; 
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd") // JSON 무관, 외부에서 값이 입력될 때 정해진 포맷으로 입력받음
	Date planStart;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date planEnd;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date planDate;
	int itemOrders;
	
	
	//	생산계획관리 페이지 :  제품 리스트
	String itemName;
	String itemType;
	
	// 생산계획 관리 페이지 : modal 계획 리스트
	String empName;
	// 생산계획 프로시저 : 생산계획 코드
	String planCode;

	String startDate;
	String endDate;
	
}
