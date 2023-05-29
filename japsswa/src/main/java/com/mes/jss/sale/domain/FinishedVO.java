package com.mes.jss.sale.domain;

import java.util.Date;

import lombok.Data;

@Data
public class FinishedVO {
	private String fLotNo;
	private int finishedCount;
	private Date storeInDate;
	private Date fExpiration;
	private String itemCode;
	private String itemName;
	private int empNo;
	private String performanceId;
	private Date endTime;
	private int passItem;
	
}
