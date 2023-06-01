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
		CommVO commVo = listVo.getComm();
		
		commMapper.updateComm(commVo);
	
		for(CommVO vo :list) {
			boolean result = commMapper.getSearchDeta(vo.getDetailsIndex()) > 0;
			if(result) {
				commMapper.updateDetali(vo);
			}else {
				vo.setCommCode(commCode);
				commMapper.insertDetails(vo);
			}
		}
		
		
	}



	@Override
	public void removeDetails(CommListVO listVo) {
		List<CommVO> list = listVo.getList();
		
		for(CommVO vo :list) {
			commMapper.deleteDetails(vo.getDetaCode());
		}
	}



	@Override
	public CommVO getCommCode(String commCode) {
		// TODO Auto-generated method stub
		return commMapper.getCommon(commCode);
	}



	@Override
	public void addCommCode(CommVO vo) {
		
		commMapper.insertCommCode(vo);
	}



	@Override
	public boolean searchComm(String commCode) {
		// TODO Auto-generated method stub
		return commMapper.searchComm(commCode) > 0;
	}



	@Override
	public void removeCommCode(String commCode) {
		// TODO Auto-generated method stub
		commMapper.deleteCommCode(commCode);
	}



	@Override
	public List<CommVO> getItemDeta() {
		// TODO Auto-generated method stub
		return commMapper.getItemDeta();
	}



	@Override
	public List<CommVO> getTypeList() {
		// TODO Auto-generated method stub
		return commMapper.getTypeList();
	}

}
