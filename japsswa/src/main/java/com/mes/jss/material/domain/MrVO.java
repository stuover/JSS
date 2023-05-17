package com.mes.jss.material.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrVO {
	private String mrLotNumber;
	private String testCode;
	private Date storeDate;
	private int inventory;
	private long empNo;
	private String performanceId;
}
