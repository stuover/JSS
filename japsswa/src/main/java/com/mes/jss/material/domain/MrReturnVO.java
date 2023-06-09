package com.mes.jss.material.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MrReturnVO {    // 자재 반품
	String mrReturnCode;
	String testCode;
	String itemCode;
	String itemName;
	long mrReturnCount;
	String mrReturnReason;
	
	String mrReturnDate;
	String mrReturnDate1;
	String mrReturnDate2;
	long empNo;
	String mrOrderDetCode;
	String CustomerName;
}
