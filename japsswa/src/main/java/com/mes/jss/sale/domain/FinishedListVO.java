package com.mes.jss.sale.domain;

import java.util.List;

import lombok.Data;

@Data
public class FinishedListVO {
	private List<FinishedVO> flist;
	private FinishedVO manager;
}
