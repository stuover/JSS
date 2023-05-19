package com.mes.jss.material.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrVO {                   // 자재 vo
	private String mrLotNumber;
	private String testCode;
	private String itemCode;
	private Date storeDate;
	private long inventory;
	private long empNo;
	private String performanceId;
	private long total;
	private long storeCount;
	
	private String itemName;
	private String itemType;
}
