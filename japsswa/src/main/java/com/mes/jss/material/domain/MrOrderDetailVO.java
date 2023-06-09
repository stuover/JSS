package com.mes.jss.material.domain;





import java.math.BigDecimal;

import lombok.Data;

@Data
public class MrOrderDetailVO {	// 자재 발주 상세
	 String mrOrderDetCode;
	 String mrOrderCode;
	 String itemCode;
	 String itemName;
	 BigDecimal itemPrice;
	 String customerId;
	 String customerName;
	 BigDecimal mrCount;
	 BigDecimal mrPrice;
	 BigDecimal priceTotal;
	
	 String deliveryDate;
	 
	 String mrOrderDate;
	 String empName;
	 
	 
}
