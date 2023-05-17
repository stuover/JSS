package com.mes.jss.quality.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.material.domain.MrVO;
import com.mes.jss.quality.domain.QualityVO;
import com.mes.jss.quality.mapper.QualityMapper;
import com.mes.jss.quality.service.QualityService;

@Service
public class QualityServiceImpl implements QualityService{
	
	@Autowired
	private QualityMapper qualityMapper;
	

	@Override
	public List<QualityVO> qlList() {
		
		return qualityMapper.getList();
	}

	@Override
	public int mrStore(MrVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
