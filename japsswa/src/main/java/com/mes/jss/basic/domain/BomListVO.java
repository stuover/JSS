package com.mes.jss.basic.domain;

import java.util.List;

import lombok.Data;

@Data
public class BomListVO {
	List<BomVO> list;
	String itemCode;
}
