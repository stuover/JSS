package com.mes.jss.facility.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.facility.domain.DowntimeVO;
import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.domain.InspectionVO;
import com.mes.jss.facility.mapper.FacilityMapper;
import com.mes.jss.facility.service.FacilityService;

@Service("facilityService")
public class FacilityServiceimpl implements FacilityService{

	@Autowired FacilityMapper facilityMapper;

	@Override
	public FacilityVO getFacility(FacilityVO vo) {
		
		return facilityMapper.getFacility(vo);
	}

	@Override
	public List<FacilityVO> getList() {
		
		return facilityMapper.getList();
	}

	@Override
	public InspectionVO getInspection(InspectionVO vo) {
		return null;
	}

	@Override
	public DowntimeVO getDowntime(DowntimeVO vo) {
		return null;
	}

	@Override
	public List<DowntimeVO> getDownList() {

		return facilityMapper.getdownList();
	}

	@Override
	public boolean registerDown(DowntimeVO vo) {
		return facilityMapper.insertDownFac(vo) > 0;
	}	
	
}
