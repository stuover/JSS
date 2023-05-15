package com.mes.jss.facility.user;

import lombok.Data;

@Data
public class DowntimeVO {

	String downCode;
	String startTime;
	String stopTime;
	String downReason;
	String downManager;
	String remark;
	String facCode;
	
//	down_code varchar2(20) PRIMARY KEY,
//	start_time varchar2(20) not null,
//	stop_time varchar2(20) not null,
//	down_reason varchar2(50) not null,
//	down_manager varchar2(12) not null,
//	remark varchar2(50),
//	fac_code varchar2(20) not null
}
