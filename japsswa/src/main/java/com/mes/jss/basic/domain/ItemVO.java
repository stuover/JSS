package com.mes.jss.basic.domain;

import lombok.Data;

@Data
public class ItemVO {

	public String itemCode;
	public String itemName;
	public String itemType;
	public long unitPrice;
	public long itemPrice;
	public double standard;
	public String unit;
	public long saveMaterial;
}
