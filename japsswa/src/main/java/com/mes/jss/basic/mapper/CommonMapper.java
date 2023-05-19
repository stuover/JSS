package com.mes.jss.basic.mapper;

import java.util.List;

import com.mes.jss.basic.domain.CommVO;

public interface CommonMapper {

	public List<CommVO> getListComm();

	public List<CommVO> getListDeta(String commCode);

}
