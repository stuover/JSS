package com.mes.jss.meterial.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrReturn {
	private String returnCode;
	private String testCode;
	private int allCount;
	private int returnCount;
	private String returnReason;
	private Date returnDate;
	private int empNo;
}
