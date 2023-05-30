package com.mes.jss.basic.domain;

import lombok.Data;

@Data
public class TransactionItemVO {
	String transNo;
	String itemCode;
	String customerId;
	
	String itemName;
	String itemType;
}
