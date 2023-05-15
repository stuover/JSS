package com.mes.jss.meterial.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrVO {
	private String lotNumber;
	private String testCode;
	private Date storeDate;
	private int inventory;
	private int empNo;
	private String performanceId;
}
