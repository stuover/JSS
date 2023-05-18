package com.mes.jss.material.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.material.domain.MrVO;
import com.mes.jss.material.mapper.MaterialMapper;
import com.mes.jss.material.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	private MaterialMapper materialMapper;

	@Override
	public int mrStore(MrVO vo) {

		return materialMapper.insert(vo);
	}
	
	// 자재 조회
	
	@Override
	public List<MrVO> mrlist() {

		return materialMapper.getList();
	}

	@Override
	public List<MrVO> searchList(String keyword) {
		
		return materialMapper.codeList(keyword);
	}

	@Override
	public List<MrVO> mrCount(String keyword) {
		
		return materialMapper.mrCountList(keyword);
	}

	

}
