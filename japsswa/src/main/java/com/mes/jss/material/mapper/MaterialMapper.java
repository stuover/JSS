package com.mes.jss.material.mapper;

import java.util.List;

import com.mes.jss.material.domain.MrVO;

public interface MaterialMapper {
	
	public int insert(MrVO vo);
	
	public List<MrVO> getList();
}
