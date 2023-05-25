package com.mes.jss.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.domain.ItemVO;
import com.mes.jss.basic.mapper.BomMapper;
import com.mes.jss.basic.service.BomService;

@Service("bomService")
public class BomServiceImpl implements BomService{
	@Autowired BomMapper bomMapper;

	@Override
	public List<ItemVO> getBomList(String itemCode) {
		// TODO Auto-generated method stub
		return bomMapper.getBomList(itemCode);
	}

}
