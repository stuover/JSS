package com.mes.jss.material.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	 @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	 @DateTimeFormat(pattern="YYYY-MM-dd" )
	 Date mrOrderDate;
}
