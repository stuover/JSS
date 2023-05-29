package com.mes.jss.quality.domain;

import lombok.Data;

@Data
public class TestHistoryVO {
	public String testHistoryCode;
	public String checklistCode;
	public String testResult;
	public double mrCount;
	public String testCode;
}
