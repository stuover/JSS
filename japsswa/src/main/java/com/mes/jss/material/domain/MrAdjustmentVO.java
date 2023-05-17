package com.mes.jss.material.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrAdjustmentVO {	// 자재 조정
	private String adjustmentCode;
	private String mrLotNumber;
	private Date registerDate;
	private String process;
	private int change;
	private Date adjustmentDate;
	private int empNo;
}
