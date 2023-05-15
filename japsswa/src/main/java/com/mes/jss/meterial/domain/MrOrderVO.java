package com.mes.jss.meterial.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrOrderVO {
	private String mrOrderCode;
	private String customerId;
	private int empNo;
	private int allCount;
	private int productCount;
	private Date mrOrderDate;
}
