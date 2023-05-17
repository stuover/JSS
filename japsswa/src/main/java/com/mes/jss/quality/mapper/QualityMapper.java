package com.mes.jss.quality.mapper;

import java.util.List;

import com.mes.jss.quality.domain.QualityVO;

public interface QualityMapper {
	
	// 품질 검사 리스트
	public List<QualityVO> getList();
	
	
}
