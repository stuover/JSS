package com.mes.jss.production.domain;

import java.util.List;

import lombok.Data;

@Data
public class WorkDatasVO {
	WorkVO head;
	List<WorkVO> detailList;
}
