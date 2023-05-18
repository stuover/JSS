package com.mes.jss.facility.mapper;

import java.util.List;

import com.mes.jss.facility.domain.DowntimeVO;
import com.mes.jss.facility.domain.FacilityVO;

public interface FacilityMapper {

	public List<FacilityVO> getList();	// 전체 설비 리스트
	public FacilityVO getFacility(FacilityVO vo);
	
	public List<DowntimeVO> getdownList();	// 비가동 리스트
	public int insertDownFac(DowntimeVO vo);
		
}
