package com.mes.jss.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.basic.domain.CommListVO;
import com.mes.jss.basic.domain.CommVO;
import com.mes.jss.basic.mapper.CommonMapper;
import com.mes.jss.basic.service.CommonService;

@Service("commonService")
public class CommonServiceImpl implements CommonService{
	
	@Autowired CommonMapper commMapper;

	@Override
	public List<CommVO> getCommListe() {
		// TODO Auto-generated method stub
		return commMapper.getListComm();
	}



	@Override
	public List<CommVO> getDetaList(String commCode) {
		// TODO Auto-generated method stub
		return commMapper.getListDeta(commCode);
	}



	@Override
	public void modifyDetails(CommListVO listVo) {
		List<CommVO> list = listVo.getList();
		String commCode = listVo.getCode();
		
		for(CommVO vo :list) {
			boolean result = commMapper.getSearchDeta(vo.getDetaCode()) > 0;
			if(result) {
				commMapper.updateDetali(vo);
			}else {
				vo.setCommCode(commCode);
				commMapper.insertDetails(vo);
			}
		}
		
		
	}

}
