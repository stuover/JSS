package com.mes.jss.material.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrErrorVO {	// 불량 자재
	private String mrErrorCode;
	private String mrLotNumber;
	private String performanceId;
	private Date mrErrorDate;
	private String mrErrorReason;
	private int empNo;
}
