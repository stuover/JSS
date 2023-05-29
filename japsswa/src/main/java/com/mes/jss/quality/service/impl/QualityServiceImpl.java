package com.mes.jss.quality.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.material.domain.MrVO;
import com.mes.jss.quality.domain.CheckListVO;
import com.mes.jss.quality.domain.QualityVO;
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

	
}
