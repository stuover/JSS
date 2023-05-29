package com.mes.jss.quality.service;

import java.util.List;

import com.mes.jss.material.domain.MrVO;
import com.mes.jss.quality.domain.CheckListVO;
import com.mes.jss.quality.domain.QualityVO;
import com.mes.jss.quality.domain.TestHistoryListVO;

public interface QualityService {

	//품질 검사 리스트
	
	public List<QualityVO> qlList();

	public List<QualityVO> qualityList();

	public List<CheckListVO> getCheckList(String itemCode);

	public void completeTest(TestHistoryListVO data);
}
