package com.mes.jss.material.domain;

import lombok.Data;

@Data
public class CriteriaVO {
	
	 String type;
	 String keyword;
	 String[] typeArr; //{T} or {TW} or {TWC}
	
	String[] getTypeArr() {
		
	return type == null ? new String[] {} : type.split("");
		
	}
}
