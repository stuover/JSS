package com.mes.jss.quality.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.DTO.SearchDTO;
import com.mes.jss.quality.domain.CheckListVO;
import com.mes.jss.quality.domain.QualityVO;
import com.mes.jss.quality.domain.TestHistoryListVO;
import com.mes.jss.quality.domain.TestHistoryVO;
import com.mes.jss.quality.mapper.QualityMapper;
import com.mes.jss.quality.service.QualityService;

@Service
public class QualityServiceImpl implements QualityService {

	@Autowired
	private QualityMapper qualityMapper;

	// 품질 검사 리스트

	@Override
	public List<QualityVO> qlList() {

		return qualityMapper.getList();
	}

	@Override
	public List<QualityVO> qualityList(SearchDTO dto) {
		// TODO Auto-generated method stub
		return qualityMapper.qualityList(dto);
	}

	@Override
	public List<CheckListVO> getCheckList(String itemCode) {
		// TODO Auto-generated method stub
		return qualityMapper.getCheckList(itemCode);
	}

	@Override
	public void completeTest(TestHistoryListVO data, long empNo) {
		QualityVO qt = data.getVo();
		qt.setEmpNo(empNo);
		int count = 0;

		// 품질 업데이트
		for (TestHistoryVO vo : data.getList()) {
			vo.setTestCode(qt.getTestCode());

			if (vo.getTestResult().equals("불합격")) {
				count++;
			}
			if(vo.getTestHistoryCode() == null) {
				qualityMapper.insertHistory(vo);
			}else { 
				qualityMapper.updateHistory(vo);
			}
		}

		if (qt.getItemType().equals("자재")) { // 입고 자제검사
			qt.setErrQuantity(data.getList().get(0).getMrCount());	
			qualityMapper.updateQuality(qt);
		} else { // 반제품 검사
			if (count > 0) {
				qt.setTestNote("불합격");
				System.err.println("ddddddddddddd");
				qualityMapper.samUpdateQuality(qt);
			} else {
				System.err.println("aaaaaaaaaaa");

				qt.setTestNote("합격");
				qualityMapper.samUpdateQuality(qt);
			}

		}

	}

	@Override
	public List<QualityVO> getPassQualityList(SearchDTO dto) {
		// TODO Auto-generated method stub
		return qualityMapper.getPassQualityList(dto);
	}

	@Override
	public List<QualityVO> getErrQualityList(SearchDTO dto) {
		// TODO Auto-generated method stub
		return qualityMapper.getErrQualityList(dto);
	}

	@Override
	public List<TestHistoryVO> getHistoryList(String testCode) {
		// TODO Auto-generated method stub
		return qualityMapper.getHistoryList(testCode);
	}

	@Override
	public void removeTest(TestHistoryListVO data) {
		qualityMapper.cancelTest(data.vo.getTestCode());
		
		for(TestHistoryVO vo : data.getList()) {
			qualityMapper.deleteTestHistory(vo.getTestHistoryCode());
		}
	}

	@Override
	public List<CheckListVO> updateItemQuality(List<CheckListVO> vo) {
		
		for(CheckListVO list : vo) {
			if(list.getChecklistCode() == null) {
				qualityMapper.insertCheckList(list);
			}else {
				qualityMapper.updateCheckList(list);
			}
			
		}
		
		
		return qualityMapper.getCheckList(vo.get(0).getItemCode());
	}

	@Override
	public List<CheckListVO> removeItemQuality(List<CheckListVO> vo) {
		for(CheckListVO list : vo) {
			if(list.getChecklistCode() != null) {
				qualityMapper.deleteCheckList(list.getChecklistCode());
			}
		}
		
		return qualityMapper.getCheckList(vo.get(0).getItemCode());
	}

}
