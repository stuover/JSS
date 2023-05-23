package com.mes.jss.basic.service;

import java.util.List;

import com.mes.jss.basic.domain.ProcessVO;

public interface ProcessService {

	List<ProcessVO> getList();

	ProcessVO getProCode();

	void addProcess(ProcessVO vo);

	void modifyProcess(ProcessVO vo);

	boolean removePro(String proCode);

}
