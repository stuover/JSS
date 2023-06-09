package com.mes.jss.material.domain;





import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	 @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	 @DateTimeFormat(pattern="YYYY-MM-dd" )
	 Date deliveryDate;
	 @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	 @DateTimeFormat(pattern="YYYY-MM-dd" )
	 Date mrOrderDate;
	 String empName;
	 
	 
}
