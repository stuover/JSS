package com.mes.jss.quality.domain;

import java.util.Date;

import lombok.Data;

@Data
public class QualityVO {	// 품질 VO
	private String testCode;
	private String itemCode;
	private String mrOrderDetail;
	private String situation;
	private String testResult;
	private Date testDate;
	private String mrCount;
	private Date exDate;
	private int checklistCode;
}
