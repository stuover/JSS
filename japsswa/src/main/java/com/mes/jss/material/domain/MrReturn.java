package com.mes.jss.material.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrReturn {    // 자재 반품
	private String returnCode;
	private String testCode;
	private int allCount;
	private int returnCount;
	private String returnReason;
	private Date returnDate;
	private int empNo;
}
