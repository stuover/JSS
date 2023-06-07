package com.mes.jss.facility.domain;

import java.util.Date;

import lombok.Data;

@Data
public class InspectionVO {

	String insCode;
	String insDate;
	String insReason;
	String insHistory;
	String judgment;
	String insManager;
	String partHistory;
	String partReason;
	String partDate;
	String facCode;
	String downCode;
	
	// 조인
	String facName;
	String downReason;
	String startDate;
	String stopDate;
	String lastInspection;
//	ins_code varchar2(20) PRIMARY KEY,
//	ins_date date not null,
//	ins_reason varchar2(20) not null,
//	ins_history varchar2(50) not null,
//	judgment varchar2(10) not null,
//	part_history varchar2(25),
//	part_reason varchar2(50),
//	part_date date,
//	ins_manager varchar2(12) not null,
//	fac_code varchar2(20) not null,
//	down_code varchar2(20)
}
