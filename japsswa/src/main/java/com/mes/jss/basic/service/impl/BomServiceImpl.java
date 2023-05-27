package com.mes.jss.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.domain.BomListVO;
import com.mes.jss.basic.domain.BomVO;
import com.mes.jss.basic.mapper.BomMapper;
import com.mes.jss.basic.mapper.ItemMapper;
import com.mes.jss.basic.service.BomService;

@Service("bomService")
public class BomServiceImpl implements BomService{
	@Autowired BomMapper bomMapper;
	@Autowired ItemMapper itemMapper;

	@Override
	public List<BomVO> getBomList(String itemCode) {
		
		String type =itemMapper.getItemType(itemCode);
		if (type.equals("반제품")) {
			return bomMapper.getSmaBomList(itemCode);
		}else{
			return bomMapper.getBomList(itemCode);
		}
		
	}




	@Override
	public void saveBom(BomListVO save) {
		System.err.println(save);
		
		for(BomVO vo : save.getList()) {
			vo.setItemCode(save.getItemCode());
			System.err.println(vo);
			if(vo.getBomCode() == null) {
				bomMapper.insertBom(vo);
			}else {
				bomMapper.updateBom(vo);
			}
		}
	}




	@Override
	public String getNumber() {
		// TODO Auto-generated method stub
		return bomMapper.getNumber();
	}




	@Override
	public void remove(BomListVO dete) {
		// TODO Auto-generated method stub
		for(BomVO vo : dete.getList()) {
			if(vo.getBomCode() != null) {
				bomMapper.deleteBom(vo);
			}
		}
	}




	@Override
	public List<BomVO> getBomManageList(String itemCode) {
		// TODO Auto-generated method stub
		return bomMapper.getBomManageList(itemCode);
	}





}
