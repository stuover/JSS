package com.mes.jss.meterial.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrAdjustmentVO {
	private String adjustmentCode;
	private String lotNumber;
	private Date registerDate;
	private String process;
	private int change;
	private Date adjustmentDate;
	private int empNo;
}
