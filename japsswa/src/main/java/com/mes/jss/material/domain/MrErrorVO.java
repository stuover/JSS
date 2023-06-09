package com.mes.jss.material.domain;





import lombok.Data;

@Data
public class MrErrorVO {	// 불량 자재
	String mrErrorCode;
	String mrLotNumber;
	String performanceId;
	
	String mrErrorDate;
	String mrErrorReason;
	long empNo;
	String mrRealCode;
	long errorCount;
	
	
	
}
