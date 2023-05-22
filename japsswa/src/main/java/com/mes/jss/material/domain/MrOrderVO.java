package com.mes.jss.material.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrOrderVO {	// 자재 발주
	private String mrOrderCode;
	private String customerId;
	private long empNo;
	private long allCount;
	private long productCount;
	private Date mrOrderDate;
}
