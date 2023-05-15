package com.mes.jss.meterial.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrErrorVO {
	private String mrErrorCode;
	private String lotNumber;
	private String performanceId;
	private Date mrErrorDate;
	private String mrErrorReason;
	private int empNo;
}
