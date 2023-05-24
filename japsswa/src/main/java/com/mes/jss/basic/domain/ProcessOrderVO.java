package com.mes.jss.basic.domain;

import lombok.Data;

@Data
public class ProcessOrderVO {
	// 공정 흐름
	public String proNo;
	public String proOrder;
	public String proCode;
	public String itmeCode;
	
	
	// 공정 정보
	public String proName;
	public String insertDate;
	public String modifyDate;

}
