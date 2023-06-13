package com.mes.jss.material.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MrReturnVO {    // 자재 반품
	String mrReturnCode;
	String testCode;
	String itemCode;
	String itemName;
	long mrReturnCount;
	String mrReturnReason;
	 @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	 @DateTimeFormat(pattern="yyyy-MM-dd" )
	Date mrReturnDate;
	 @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	 @DateTimeFormat(pattern="yyyy-MM-dd" )
	Date mrReturnDate1;
	 @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	 @DateTimeFormat(pattern="yyyy-MM-dd" )
	Date mrReturnDate2;
	long empNo;
	String empName;
	String mrOrderDetCode;
	String CustomerName;
}
