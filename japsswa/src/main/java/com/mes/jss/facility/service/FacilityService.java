package com.mes.jss.facility.service;

import java.util.List;

import com.mes.jss.facility.user.DowntimeVO;
import com.mes.jss.facility.user.FacilityVO;
import com.mes.jss.facility.user.InspectionVO;

public interface FacilityService {

	FacilityVO getFacility(FacilityVO vo);
	List<FacilityVO> getList();
	InspectionVO getInspection(InspectionVO vo);
	DowntimeVO getDowntime(DowntimeVO vo);
}
