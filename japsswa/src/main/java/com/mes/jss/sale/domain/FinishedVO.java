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
	 Date endTime;
	 long passItem;
	 String ordDetStatus;
	
}
