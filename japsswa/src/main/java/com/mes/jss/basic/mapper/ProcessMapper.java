package com.mes.jss.basic.mapper;

import java.util.List;

import com.mes.jss.DTO.SearchDTO;
import com.mes.jss.basic.domain.ProcessVO;

public interface ProcessMapper {

	List<ProcessVO> getList(SearchDTO dto);

	ProcessVO getProCode();

	void insertProcess(ProcessVO vo);

	void updateProcess(ProcessVO vo);

	boolean deleteProcess(String proCode);

}
