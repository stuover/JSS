package com.mes.jss.material.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrReleaseVO {   // 자재 출고
	 String mrRealCode;
	 String mrLotNumber;
	 String performanceId;
	 String itemCode;
	 String adjustmentCode;
	 long mrRealCount;
	 String mrRealReasonType;
	 String mrRealReasonCode;
	 String itemType;
	 String itemName;
	 String mrRealDate;
	 String mrRealDate1;
	 String mrRealDate2;
	 String mrSearch;
	 
}
