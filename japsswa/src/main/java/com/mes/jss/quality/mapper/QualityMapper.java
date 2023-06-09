package com.mes.jss.quality.mapper;

import java.util.List;

import com.mes.jss.DTO.SearchDTO;
import com.mes.jss.quality.domain.CheckListVO;
import com.mes.jss.quality.domain.QualityVO;
import com.mes.jss.quality.domain.TestHistoryVO;

public interface QualityMapper {
	
	// 품질 검사 리스트
	public List<QualityVO> getList();


	public List<QualityVO> qualityList(SearchDTO dto);


	public List<CheckListVO> getCheckList(String itemCode);


	public void updateQuality(QualityVO qt);


	public void samUpdateQuality(QualityVO qt);


	public void insertHistory(TestHistoryVO vo);


	public List<QualityVO> getPassQualityList(SearchDTO dto);


	public List<QualityVO> getErrQualityList(SearchDTO dto);


	public List<TestHistoryVO> getHistoryList(String testCode);


	public void updateHistory(TestHistoryVO vo);


	public void cancelTest(String testCode);


	public void deleteTestHistory(String testHistoryCode);


	public void insertCheckList(CheckListVO list);


	public void updateCheckList(CheckListVO list);


	public void deleteCheckList(String checklistCode);
	
	
}
