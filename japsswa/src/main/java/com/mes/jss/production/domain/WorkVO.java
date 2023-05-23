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
	
	String planId;
	String planName;
	String itemName;
	
	String wbomId;
	String proCode;
	String proName;
	int proSeq;
	int instructNum;
	int passItem;
	int failItem;
	String successStatus;
	
	String holdId;
	String holdLot;
	int holdAmount;
	String intuseAmount;
	String holdStatus;
	
	// 자재lot
	String mrLotNumber;
	
	// BOM에서 자재 소요량
	int itemCon;
}
