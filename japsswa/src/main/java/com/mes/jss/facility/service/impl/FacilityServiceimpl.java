package com.mes.jss.facility.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mes.jss.basic.domain.CommVO;
import com.mes.jss.facility.domain.DowntimeVO;
import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.domain.InspectionVO;
import com.mes.jss.facility.mapper.FacilityMapper;
import com.mes.jss.facility.service.FacilityService;

@Service
public class FacilityServiceimpl implements FacilityService{

	@Autowired FacilityMapper facilityMapper;

	// 비가동 페이지		

	@Override
	public List<FacilityVO> getList() {	// 전체 설비 리스트 조회
		
		return facilityMapper.getList();
	}
	
	@Override
	public List<DowntimeVO> getDownList() {	// 비가동 리스트 조회

		return facilityMapper.getdownList();
	}

	@Override
	public boolean setDownTime(DowntimeVO vo) {		// 설비 비가동 등록
		
		return facilityMapper.insertDownList(vo) == 1;
		
	}

	@Override
	public boolean updateFacList(FacilityVO vo) {	// 비가동시 설비 가동상태 변경
		
		return facilityMapper.updateFacStatus(vo);
	}
	
	@Override
	public boolean newUpdateFacList(FacilityVO vo) {		// 가동시 설비 가동상태 변경

		return facilityMapper.newUpdateFacStatus(vo);
	}

	@Override
	public boolean updateStartDate(DowntimeVO vo) {	// 가동일시 추가
			
			return facilityMapper.insertStartTime(vo);
	}	

	@Override
	public boolean removeDownTime(FacilityVO vo) {		// 비가동 내역 삭제

		return facilityMapper.deleteDownCode(vo);
	}

	@Override
	public boolean modifyDownTime(DowntimeVO vo) {		// 비가동 내역 수정

		return facilityMapper.updateDownTime(vo);
	}

	
	
	// 비가동 내역 페이지
	
	@Override
	public List<DowntimeVO> getDownDetail() {	// 비가동 내역 전체 조회
		
		return facilityMapper.getDownDetailList();
	}

	@Override
	public List<FacilityVO> searchList(FacilityVO vo) {		// 비가동 내역 단건 조회

		return facilityMapper.searchlist(vo);
	}

	
	
	
	// 설비 관리 페이지
	
	@Override
	public List<FacilityVO> getAllList() {		// 전체 설비 리스트
		
		return facilityMapper.getAllList();
	}

	
	@Override
	public List<FacilityVO> searchFacility(FacilityVO vo) {		// 설비 단건 조회

		return facilityMapper.searchFac(vo);
	}
		
	 
	@Override
	public boolean saveFacility(FacilityVO vo) {		// 설비 등록
		
		return facilityMapper.insertFacility(vo) == 1;
	}

	@Override
	public void modifyFacility(FacilityVO vo) {		// 설비 정보 수정

		facilityMapper.modifyFac(vo);
	}
	
	@Override
	public void RemoveFacility(FacilityVO vo) {

		facilityMapper.deleteFac(vo);
	}

	
	// 점검 관리 페이지
	
	@Override
	public List<InspectionVO> getbeforeInsList() {	// 점검 등록 전 리스트
		
		return facilityMapper.getbeInsList();
	}

	@Override
	public List<InspectionVO> getInspectionList() {	// 점검 리스트

		return facilityMapper.getInsList();
	}

	@Override
	public List<FacilityVO> getSelectList() {		// 점검 등록 - facCode 리스트 불러오기

		return facilityMapper.getSelList();
	}
	
	@Override
	@Transactional
	public boolean saveInspection(InspectionVO vo) {		// 비가동 = 점검등록
		
		int i = 0;
		i=facilityMapper.insertModalIns(vo);
		if(i == 1) {
			i+=facilityMapper.modifyFacDate(vo);	
		}
		return  i>0;
		
	}

	@Override
	public void modifyInspection(InspectionVO vo) {

		facilityMapper.modifyIns(vo);
	}

	@Override
	public void RemoveInspection(InspectionVO vo) {	
		
		facilityMapper.deleteIns(vo);
	}

	@Override
	public List<InspectionVO> searchInsList(InspectionVO vo) {	// 점검 내역 검색
		
		return facilityMapper.searchInsList(vo);
	}

	@Override
	public List<CommVO> getDetailList(String commCode) {
		// TODO Auto-generated method stub
		return facilityMapper.getDetailList(commCode);
	}

	@Override
	public void updateFacDate(FacilityVO vo) {

		
	}

	

	

	


	

	



	


	

	
	
}
