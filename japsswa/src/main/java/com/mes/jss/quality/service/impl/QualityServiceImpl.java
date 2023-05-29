package com.mes.jss.quality.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.quality.domain.CheckListVO;
import com.mes.jss.quality.domain.QualityVO;
import com.mes.jss.quality.domain.TestHistoryListVO;
import com.mes.jss.quality.domain.TestHistoryVO;
import com.mes.jss.quality.mapper.QualityMapper;
import com.mes.jss.quality.service.QualityService;

@Service
public class QualityServiceImpl implements QualityService{
	
	@Autowired
	private QualityMapper qualityMapper;
	
	
	
	// 품질 검사 리스트
	
	
	@Override
	public List<QualityVO> qlList() {
		
		return qualityMapper.getList();
	}



	@Override
	public List<QualityVO> qualityList() {
		// TODO Auto-generated method stub
		return qualityMapper.qualityList();
	}



	@Override
	public List<CheckListVO> getCheckList(String itemCode) {
		// TODO Auto-generated method stub
		return qualityMapper.getCheckList(itemCode);
	}



	@Override
	public void completeTest(TestHistoryListVO data) {
		QualityVO qt = data.getVo();
		int count = 0;
		
		for(TestHistoryVO  vo : data.getList()) {
			vo.setTestCode(qt.getTestCode());
			
			if(vo.getTestResult().equals("불합격")){
				count++;
			}
			qualityMapper.insertHistory(vo);
		}
		
		if(qt.getItemType().equals("자재")){
			qt.setErrQuantity(data.getList().get(0).getMrCount());
			qualityMapper.updateQuality(qt);
		}else {
			if(count >0) {
				qt.setTestNote("불합격");
				qualityMapper.samUpdateQuality(qt);
			}else { 
				qt.setTestNote("합격");
				qualityMapper.samUpdateQuality(qt);
			}
			
		}
	
	}

	
}
