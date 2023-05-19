package com.mes.jss.production.domain;

import java.util.List;

import lombok.Data;

@Data
public class PlanDatasVO {
	private PlanVO head;
	private List<PlanVO> detailList;
}
