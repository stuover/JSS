package com.mes.jss.material.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.material.domain.MrVO;
import com.mes.jss.material.mapper.MaterialMapper;
import com.mes.jss.material.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	private MaterialMapper meterialMapper;

	@Override
	public int mrStore(MrVO vo) {

		return meterialMapper.insert(vo);
	}

	@Override
	public List<MrVO> mrlist() {

		return meterialMapper.getList();
	}

	

}
