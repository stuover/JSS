package com.mes.jss.facility.domain;

import java.util.Date;

import lombok.Data;

@Data
public class DowntimeVO {

	String downCode;
	String startDate;
	String stopDate;
	String downReason;
	String downManager;
	String remark;
	String facCode;
	
	// 조인
	String facName;
	String text;
	String nameText;
	

//	facName
//	facCode
//	downReason
//	stopTime
//	downManager
	
//	down_code varchar2(20) PRIMARY KEY,
//	start_time varchar2(20) not null,
//	stop_time varchar2(20) not null,
//	down_reason varchar2(50) not null,
//	down_manager varchar2(12) not null,
//	remark varchar2(50),
//	fac_code varchar2(20) not null
}


//columns: [
//          {
//            header: '설비명',
//            name: 'facName'
//          },
//          {
//            header: '설비 코드',
//            name: 'facCode'
//          },
//          {
//            header: '비가동 코드',
//            name: 'downCode'
//          },
//          {
//            header: '비가동 사유',
//            name: 'downReason'
//          },
//          {
//            header: '설비 가동일시',
//            name: 'startDate'
//          },
//          {
//              header: '설비 비가동일시',
//              name: 'stopDate'
//            },                        
//             {
//                  header: '관리자',
//                  name: 'downManager'
//                },
//                {
//                    header: '비고',
//                    name: 'remark'
//                  }
//        ]