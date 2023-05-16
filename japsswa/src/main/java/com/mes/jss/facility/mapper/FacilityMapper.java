package com.mes.jss.facility.mapper;

import java.util.List;

import com.mes.jss.facility.user.FacilityVO;

public interface FacilityMapper {

	List<FacilityVO> getList();
	FacilityVO getFacility(FacilityVO vo);
	
}
