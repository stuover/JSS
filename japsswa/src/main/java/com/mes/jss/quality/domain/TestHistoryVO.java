package com.mes.jss.quality.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TestHistoryVO {
	public String testHistoryCode;
	public String checklistCode;
	public String testResult;
	public BigDecimal mrCount;
	public String testCode;
	
	
	public String testName;
	public String facName;
	public String testStandard;
	public String itemCode;
}
