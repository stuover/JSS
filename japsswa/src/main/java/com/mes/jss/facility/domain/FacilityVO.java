package com.mes.jss.facility.domain;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class FacilityVO {

	String facCode;
	String facName;
	String facDate;
	String facFunction;
	String facPicture;
	String facStatus;
	String washCycle;
	String insCycle;
	String lastInspection;
	String facManager;
	
	// 조인할때 필요
	String downCode;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss a", timezone = "Asia/Seoul")
	String startDate;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss a", timezone = "Asia/Seoul")
	String stopDate;
	String insDate;
	
	String downReason;
	String downManager;
	String remark;
	
	// 공정 불러오기
	String proCode;
	String proName;
	String empName;
	String text;
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
