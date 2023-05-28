package com.mes.jss.facility.service.impl;

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

	// 비가동 페이지
	
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
	public boolean registerDownList(DowntimeVO vo) {
		
		return facilityMapper.insertDownList(vo) > 0;
	}

	@Override
	public void setDownTime(DowntimeVO vo) {
		facilityMapper.insertDownList(vo);
		
	}

	@Override
	public boolean updateFacList(FacilityVO vo) {
		
		return facilityMapper.updateFacStatus(vo);
	}
	
	@Override
	public boolean newUpdateFacList(FacilityVO vo) {

		return facilityMapper.newUpdateFacStatus(vo);
	}

	@Override
	public boolean updateStartDate(DowntimeVO vo) {
			
			return facilityMapper.insertStartTime(vo);
	}	

	@Override
	public boolean removeDownTime(FacilityVO vo) {

		return facilityMapper.deleteDownCode(vo);
	}

	@Override
	public boolean modifyDownTime(DowntimeVO vo) {

		return facilityMapper.updateDownTime(vo);
	}

	// 비가동 내역 페이지
	
	@Override
	public List<DowntimeVO> getDownDetail() {
		
		return facilityMapper.getDownDetailList();
	}

	@Override
	public List<FacilityVO> searchList(String facName) {

		return facilityMapper.searchlist(facName);
	}

	// 설비 페이지
	
	@Override
	public List<FacilityVO> getAllList() {
		
		return facilityMapper.getAllList();
	}

	@Override
	public List<FacilityVO> searchFacility(String facCode) {
		
		return facilityMapper.searchFac(facCode);
	}


	
	
}
