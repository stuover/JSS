package com.mes.jss.material.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MrOrderVO {	// 자재 발주
	 String mrOrderCode;
	 String customerId;
	 String customerName;
	 long empNo;
	 String empName;
	 BigDecimal allCount;
	 BigDecimal productCount;
	
	 String mrOrderDate;
}
