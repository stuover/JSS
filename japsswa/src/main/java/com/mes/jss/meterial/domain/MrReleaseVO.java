package com.mes.jss.meterial.domain;

import lombok.Data;

@Data
public class MrReleaseVO {
	private String mrRealCode;
	private String lotNumber;
	private String performanceId;
	private String itemCode;
	private String adjustmentCode;
	private int mrRealCount;
}
