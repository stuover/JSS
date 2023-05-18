package com.mes.jss.material.service;

import java.util.List;
import java.util.Map;

import com.mes.jss.material.domain.MrVO;

public interface MaterialService {

	public int mrStore(MrVO vo);
	
	// 자재 조회
	public List<MrVO> mrlist();
	
	// 입고 검색
	public List<MrVO> searchList(String keyword);
	
	// 자재 검색
	public List<MrVO> mrCount(String keyword);
	
	
}
