package com.mes.jss.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.domain.BomListVO;
import com.mes.jss.basic.domain.BomVO;
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




	@Override
	public void saveBom(BomListVO save) {
		System.err.println(save);
		
		for(BomVO vo : save.getList()) {
			vo.setItemCode(save.getItemCode());
			System.err.println(vo);
			if(vo.getBomCode() == null) {
				bomMapper.insertBom(vo);
			}
		}
	}

}
