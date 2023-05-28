package com.mes.jss.material.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MrReturnVO {    // 자재 반품
	String mrReturnCode;
	String testCode;
	String itemCode;
	int mrReturnCount;
	String mrReturnReason;
	@DateTimeFormat(pattern="YYYY-MM-dd")
	Date mrReturnDate;
	int empNo;
}
