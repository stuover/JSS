package com.mes.jss.production.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class WorkVO {
	String workId;
	Long empNo;
	String workName;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd" )
	Date workDate;
	String wdetailId;
	String pdetailId;
	String itemCode;
	long workAmount;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date workStart;
	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date workEnd;
	String modifyOption;	// 작업지시 수정 가능 여부

	// 생산계획
	String planId;
	String planName;
	String itemName;
	String empName;
	
	// 작업지시 공정정보
	String wbomId;
	String proCode;
	String proName;
	int proOrder;
	int proSeq;
	long instructNum;

	
	//홀드 자재
	String holdId;
	String holdLot;
	Long holdCount;
	
	// 자재
	String mrLotNumber;	// 자재lot	
	int itemCon;	// BOM 소요량
	String itemType;	// 물품 구분 (완제품, 반제품, 자재)
	Long currentCount;		// 현 재고량 

	@JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date endTime;		// 작업 완료 시간
	
}
