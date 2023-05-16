package com.mes.jss.material.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrOrderDetailVO {
	private String mrOrderDetail;
	private String mrOrderCode;
	private String itemCode;
	private int mrCount;
	private Date deliveryDate;
}
