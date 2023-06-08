package com.mes.jss.sale.domain;

import java.util.Date;

import lombok.Data;

@Data
public class FinishedVO {
	 String fnLotNo;
	 long fnCount;
	 Date fnStoreIn;
	 Date fnExpiration;
	 String itemCode;
	 String itemName;
	 long empNo;
	 String empName;
	 String performanceId;
	 String endTime;
	 long passItem;
	 String orddetStatus;
	 String worker;
	 String perStatus;
	
}
