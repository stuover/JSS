package com.mes.jss.basic.domain;

import java.util.List;

import lombok.Data;

@Data
public class CommListVO {
	 List<CommVO> list;
	 String code;
	 CommVO comm;

}
