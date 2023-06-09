package com.mes.jss.material.domain;





import lombok.Data;

@Data
public class MrOrderDetailVO {	// 자재 발주 상세
	 String mrOrderDetCode;
	 String mrOrderCode;
	 String itemCode;
	 String itemName;
	 long itemPrice;
	 String customerId;
	 String customerName;
	 long mrCount;
	 long mrPrice;
	 long priceTotal;
	
	 String deliveryDate;
	 
	 String mrOrderDate;
	 String empName;
	 
	 
}
