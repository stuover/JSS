package com.mes.jss.facility.service;

import java.util.List;

import com.mes.jss.basic.domain.CommVO;
import com.mes.jss.basic.domain.EmpVO;
import com.mes.jss.facility.domain.DowntimeVO;
import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.domain.InspectionVO;

public interface FacilityService {

	// 비가동 리스트
	public List<FacilityVO> getList();		// 전체 설비 리스트 조회
	public List<DowntimeVO> getDownList();		// 비가동 리스트 조회
	
	
	public boolean setDownTime(DowntimeVO vo);		// 설비 비가동 등록
	public boolean updateStartDate(DowntimeVO vo);		// 가동일시 추가

	public boolean updateFacList(FacilityVO vo);		// 비가동시 설비 가동상태 변경
	public boolean newUpdateFacList(FacilityVO vo);		// 가동시 설비 가동상태 변경
	

	public boolean removeDownTime(FacilityVO vo);	// 비가동 내역 삭제
	public boolean modifyDownTime(DowntimeVO vo);	// 비가동 내역 수정

	
	
	// 비가동 내역 페이지
	public List<DowntimeVO> getDownDetail();	// 비가동 내역 전체 조회
	public List<FacilityVO> searchList(FacilityVO vo);	// 비가동 내역 검색
		
	
	
	// 설비 페이지
	public List<FacilityVO> getAllList();		// 전체 설비 리스트
	public List<FacilityVO> searchFacility(FacilityVO vo);	// 설비 검색
	
	public boolean saveFacility(FacilityVO vo);		// 설비 정보 등록
	public void modifyFacility(FacilityVO vo);		// 설비 정보 수정
	public void RemoveFacility(FacilityVO vo);	// 설비 삭제

	
	
	// 점검 페이지	
	public List<InspectionVO> getbeforeInsList();		// 점검 등록 전 리스트(비가동사유=점검)
	public List<InspectionVO> getInspectionList();	// 점검내역 리스트
	public List<FacilityVO> getSelectList();		// 점검 등록 - facCode 리스트 불러오기
	public boolean saveInspection(InspectionVO vo);	// 모달 점검 등록
	public void updateFacDate(FacilityVO vo);
	public void modifyInspection(InspectionVO vo);	// 점검 내역 수정
	public void RemoveInspection(InspectionVO vo);	// 점검 내역 삭제
	public List<InspectionVO> searchInsList(InspectionVO vo);	// 점검 내역 검색
	public List<CommVO> getDetailList(String commCode);
	public List<EmpVO> getEmp(String empNo);
	//public Object getEmpNo(String string);
	

	

}
