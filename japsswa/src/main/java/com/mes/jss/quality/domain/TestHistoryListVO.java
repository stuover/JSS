package com.mes.jss.quality.domain;

import java.util.List;

import lombok.Data;
@Data
public class TestHistoryListVO {
	public	List<TestHistoryVO> list;
	public QualityVO vo;
}
