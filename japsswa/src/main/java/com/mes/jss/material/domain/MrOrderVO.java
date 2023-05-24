package com.mes.jss.material.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrOrderVO {	// 자재 발주
	 String mrOrderCode;
	 String customerId;
	 String customerName;
	 long empNo;
	 String empName;
	 long allCount;
	 long productCount;
	 Date mrOrderDate;
}
