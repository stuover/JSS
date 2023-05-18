package com.mes.jss.facility.service;

import java.util.List;

import com.mes.jss.facility.domain.DowntimeVO;
import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.domain.InspectionVO;

public interface FacilityService {

	FacilityVO getFacility(FacilityVO vo);
	List<FacilityVO> getList();	// 전체 설비 리스트
	DowntimeVO getDowntime(DowntimeVO vo);
	List<DowntimeVO> getDownList();	// 비가동 리스트
	InspectionVO getInspection(InspectionVO vo);
}
