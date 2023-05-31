package com.mes.jss.basic.domain;

import java.util.List;

import lombok.Data;
@Data
public class TransListVO {
	List<TransactionItemVO> list;
	String cusCode;
	CustomerVO deta;
}
