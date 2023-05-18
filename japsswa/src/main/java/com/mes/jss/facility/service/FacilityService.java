package com.mes.jss.facility.service;

import java.util.List;

import com.mes.jss.facility.domain.DowntimeVO;
import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.domain.InspectionVO;

public interface FacilityService {

	public FacilityVO getFacility(FacilityVO vo);
	public List<FacilityVO> getList();		// 전체 설비 리스트
	
	public DowntimeVO getDowntime(DowntimeVO vo);
	public List<DowntimeVO> getDownList();		// 비가동 리스트
	public boolean registerDown(DowntimeVO vo);		// 비가동 사유 등록
	
	public InspectionVO getInspection(InspectionVO vo);
}
