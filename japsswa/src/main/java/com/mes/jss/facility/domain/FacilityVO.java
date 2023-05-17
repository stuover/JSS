package com.mes.jss.facility.domain;

import java.util.Date;

import lombok.Data;

@Data
public class FacilityVO {

	String facCode;
	String facName;
	Date facDate;
	String facFunction;
	String facPicture;
	String facProcess;
	String facStatus;
	String washCycle;
	String insCycle;
	Date lastInspection;
	String facManager;
	
	// 조인할때 필요
	String downCode;
	String startDate;
	String stopDate;
	String downReason;
	String downManager;

//	facName
//	facCode
//	facManager
//	facStatus
		
//	fac_code varchar2(20) PRIMARY KEY,
//	fac_name varchar2(25) not null,
//	fac_date date,
//	fac_function varchar2(50),
//	fac_picture varchar2(500),
//	fac_process varchar2(20) not null,
//	fac_status char(1) not null,
//	wash_cycle varchar2(20),
//	ins_cycle varchar2(20),
//	last_inspection date,
//	fac_manager varchar2(12) not null
}
