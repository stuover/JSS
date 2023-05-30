package com.mes.jss.production.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class WorkVO {
	String workId;
	Long empNo;
	String workName;
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date workDate;
	String wdetailId;
	String pdetailId;
	String itemCode;
	int workAmount;
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date workStart;
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date workEnd;

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
	int instructNum;
	int passItem;
	int failItem;
	String successStatus;
	
	//홀드 자재
	String holdId;
	String holdLot;
	int holdAmount;
	
	// 자재
	String mrLotNumber;	// 자재lot	
	int itemCon;	// BOM 소요량
	String itemType;	// 물품 구분 (완제품, 반제품, 자재)
}
