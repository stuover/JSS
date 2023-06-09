package com.mes.jss.basic.domain;

import lombok.Data;

@Data
public class CommVO {
	// 공통 그룹 코드
	public String commCode;
	public String commName;
	public String commNote;
	public String insertDate;
	public String modifyDate;
	
	//세부 공통 코드
	public String detaCode;
	public String detaName;
	public String detaNote;
	public String detaInsertDate;
	public String detaModifyDate;
	
	public String detailsIndex;
	
	public String text;
	public String value;

}
