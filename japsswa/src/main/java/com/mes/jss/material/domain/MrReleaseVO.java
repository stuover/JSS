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
	 int mrRealCount;
	 String mrRealReasonType;
	 String mrRealReasonCode;
	 String itemType;
	 String itemName;
	 Date mrRealDate;
	 Date mrRealDate1;
	 Date mrRealDate2;
	 String mrSearch;
	 
}
