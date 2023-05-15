package com.mes.jss.facility.service;

import com.mes.jss.facility.user.DowntimeVO;
import com.mes.jss.facility.user.FacilityVO;
import com.mes.jss.facility.user.InspectionVO;

public interface FacilityService {

	FacilityVO getFacility(FacilityVO vo);
	
	InspectionVO getInspection(InspectionVO vo);
	DowntimeVO getDowntime(DowntimeVO vo);
}
