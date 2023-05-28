package com.mes.jss.basic.domain;

import lombok.Data;

@Data
public class BomVO {
	
	public String level;
	public String path;
	// bom 정보
	public String bomCode;
	public String bomLevel;
	public String itemCon;
	public String unit;
	public String itemType;
	public String proCode;
	public String levelType;
	public String itemCode;
	public String ingCode;
	
	// 품목
	public String itemName;
	public long unitPrice;
	public long itemPrice;
	public double standard;
	public long saveMaterial;
	
	//공정정보
	public String proName;
	public String insertDate;
	public String modifyDate;
	public String proOrder;

	//자재정보
	public String mrLotNumber;
	public long storeCount;
	
	
}
