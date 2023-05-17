package com.mes.jss.material.mapper;

import java.util.List;
import java.util.Map;

import com.mes.jss.material.domain.MrVO;

public interface MaterialMapper {
	
	public int insert(MrVO vo);
	
	// 자재 조회
	
	public List<MrVO> getList();	
	
	
}
