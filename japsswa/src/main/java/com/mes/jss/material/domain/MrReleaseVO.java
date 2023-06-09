package com.mes.jss.material.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MrReleaseVO {   // 자재 출고
	 String mrRealCode;
	 String mrLotNumber;
	 String performanceId;
	 String itemCode;
	 String adjustmentCode;
	 long mrRealCount;
	 String mrRealReasonType;
	 String mrRealReasonCode;
	 String itemType;
	 String itemName;
	 @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	 @DateTimeFormat(pattern="YYYY-MM-dd" )
	 Date mrRealDate;
	 @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	 @DateTimeFormat(pattern="YYYY-MM-dd" )
	 Date mrRealDate1;
	 @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+9")
	 @DateTimeFormat(pattern="YYYY-MM-dd" )
	 Date mrRealDate2;
	 String mrSearch;
	 
}
