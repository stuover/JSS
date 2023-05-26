package com.mes.jss.facility.service;

import java.util.List;

import com.mes.jss.facility.domain.DowntimeVO;
import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.domain.InspectionVO;

public interface FacilityService {

	// 비가동
	public FacilityVO getFacility(FacilityVO vo);
	public List<FacilityVO> getList();		// 전체 설비 리스트 조회
	
	public DowntimeVO getDowntime(DowntimeVO vo);
	public List<DowntimeVO> getDownList();		// 비가동 리스트 조회
	public boolean registerDownList(DowntimeVO vo);		// 비가동 리스트 등록
	
	public InspectionVO getInspection(InspectionVO vo);
	public void setDownTime(DowntimeVO vo);
	
	public boolean updateFacList(FacilityVO vo);
	public boolean newUpdateFacList(FacilityVO vo);
	
	public boolean updateStartDate(DowntimeVO vo);
	public boolean removeDownTime(FacilityVO vo);	// 비가동 삭제
	public boolean modifyDownTime(DowntimeVO vo);

	public List<DowntimeVO> getDownDetail();	// 비가동 내역 조회
	public List<FacilityVO> searchList(String facName);
	
	// 설비
	public List<FacilityVO> getAllList();		// 전체 설비 리스트
	
}
