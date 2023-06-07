package com.mes.jss.basic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.DTO.SearchDTO;
import com.mes.jss.basic.domain.ProcessVO;
import com.mes.jss.basic.mapper.ProcessMapper;
import com.mes.jss.basic.service.ProcessService;

@Service("processService")
public class ProcessServiceImpl implements ProcessService{
	@Autowired ProcessMapper proMapper;

	@Override
	public List<ProcessVO> getList(SearchDTO dto) {
		// TODO Auto-generated method stub
		return proMapper.getList(dto);
	}

	@Override
	public ProcessVO getProCode() {
		// TODO Auto-generated method stub
		return proMapper.getProCode();
	}

	@Override
	public void addProcess(ProcessVO vo) {
		proMapper.insertProcess(vo);
	}

	@Override
	public void modifyProcess(ProcessVO vo) {
		proMapper.updateProcess(vo);
	}

	@Override
	public boolean removePro(String proCode) {
		// TODO Auto-generated method stub
		return proMapper.deleteProcess(proCode);
	}

	@Override
	public List<ProcessVO> getProcess(SearchDTO dto) {
		// TODO Auto-generated method stub
		return proMapper.getList(dto);
	}

}
