package com.mes.jss.quality.mapper;

import java.util.List;

import com.mes.jss.quality.domain.CheckListVO;
import com.mes.jss.quality.domain.QualityVO;
import com.mes.jss.quality.domain.TestHistoryVO;

public interface QualityMapper {
	
	// 품질 검사 리스트
	public List<QualityVO> getList();


	public List<QualityVO> qualityList();


	public List<CheckListVO> getCheckList(String itemCode);


	public void updateQuality(QualityVO qt);


	public void samUpdateQuality(QualityVO qt);


	public void insertHistory(TestHistoryVO vo);


	public List<QualityVO> getPassQualityList();


	public List<QualityVO> getErrQualityList();


	public List<TestHistoryVO> getHistoryList(String testCode);


	public void updateHistory(TestHistoryVO vo);


	public void cancelTest(String testCode);


	public void deleteTestHistory(String testHistoryCode);
	
	
}
