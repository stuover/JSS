package com.mes.jss.material.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MrReturnVO {    // 자재 반품
	String mrReturnCode;
	String testCode;
	String itemCode;
	int mrReturnCount;
	String mrReturnReason;
	Date mrReturnDate;
	int empNo;
}
