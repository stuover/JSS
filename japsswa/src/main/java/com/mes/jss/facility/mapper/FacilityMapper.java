package com.mes.jss.facility.mapper;

import java.util.List;

import com.mes.jss.facility.domain.DowntimeVO;
import com.mes.jss.facility.domain.FacilityVO;

public interface FacilityMapper {

	// 비가동 페이지
	public List<FacilityVO> getList();	// 전체 설비 리스트 조회
	public FacilityVO getFacility(FacilityVO vo);
	
	public List<DowntimeVO> getdownList();	// 비가동 리스트 조회
	public int insertDownList(DowntimeVO vo);		// 비가동 리스트 추가	
	
	public boolean updateFacStatus(FacilityVO vo);
	public boolean newUpdateFacStatus(FacilityVO vo);

	public boolean insertStartTime(DowntimeVO vo);
	public boolean deleteDownCode(FacilityVO vo);	// 삭제
	public boolean updateDownTime(DowntimeVO vo);	// 수정

	// 비가동 내역
	public List<DowntimeVO> getDownDetailList();
	public List<FacilityVO> searchlist(String facName);
	
	// 설비 페이지
	public List<FacilityVO> getAllList();
	
}
