package com.mes.jss.basic.mapper;

import java.util.List;

import com.mes.jss.basic.domain.CommVO;

public interface CommonMapper {

	public List<CommVO> getListComm();

	public List<CommVO> getListDeta(String commCode);

	public int getSearchDeta(String detailsIndex);

	public void updateDetali(CommVO vo);

	public void insertDetails(CommVO vo);

	public void deleteDetails(String detaCode);

	public CommVO getCommon(String commCode);

	public void updateComm(CommVO commVo);

	public void insertCommCode(CommVO vo);

	public int searchComm(String commCode);

	public void deleteCommCode(String commCode);

	public List<CommVO> getItemDeta();

	public List<CommVO> getTypeList();

}
