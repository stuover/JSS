package com.mes.jss.material.domain;

import lombok.Data;

@Data
public class MrReleaseVO {   // 자재 출고
	 String mrRelCode;
	 String mrLotNumber;
	 String performanceId;
	 String itemCode;
	 String adjustmentCode;
	 int mrRelCount;
	 String mrRelReasonCode;
}
