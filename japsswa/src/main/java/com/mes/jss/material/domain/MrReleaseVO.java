package com.mes.jss.material.domain;

import lombok.Data;

@Data
public class MrReleaseVO {   // 자재 출고
	private String mrRealCode;
	private String mrLotNumber;
	private String performanceId;
	private String itemCode;
	private String adjustmentCode;
	private int mrRealCount;
	
}
