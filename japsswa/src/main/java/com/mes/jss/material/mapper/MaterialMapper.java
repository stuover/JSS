package com.mes.jss.material.mapper;

import java.util.List;
import java.util.Map;

import com.mes.jss.material.domain.MrVO;

public interface MaterialMapper {
	
	public int insert(MrVO vo);
	
	// 자재 조회
	
	public List<MrVO> getList();	
	
	// 코드 검색
	public List<MrVO> codeList(String keyword);
	
	// 자재명 검색
	public List<MrVO> mrCountList(String keyword);
	
	// 입고 처리
	public MrVO StoreIn(String testCode);
	
}
