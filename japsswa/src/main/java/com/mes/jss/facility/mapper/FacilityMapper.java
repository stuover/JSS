package com.mes.jss.facility.mapper;

import java.util.List;

import com.mes.jss.facility.domain.DowntimeVO;
import com.mes.jss.facility.domain.FacilityVO;

public interface FacilityMapper {

	// 비가동 페이지
	public List<FacilityVO> getList();	// 전체 설비 리스트 조회
	public List<DowntimeVO> getdownList();	// 비가동 리스트 조회
	
	public int insertDownList(DowntimeVO vo);		// 설비 비가동 등록		
	
	public boolean updateFacStatus(FacilityVO vo);		// 비가동시 설비 가동상태 변경
	public boolean newUpdateFacStatus(FacilityVO vo);	// 가동시 설비 가동상태 변경

	public boolean insertStartTime(DowntimeVO vo);	// 가동일시 추가
	public boolean deleteDownCode(FacilityVO vo);	// 비가동 내역 삭제
	public boolean updateDownTime(DowntimeVO vo);	// 비가동 내역 수정

	// 비가동 내역
	public List<DowntimeVO> getDownDetailList();		// 비가동 내역 전체 조회
	public List<FacilityVO> searchlist(String facName);	// 비가동 내역 단건 조회
	
	// 설비 페이지
	public List<FacilityVO> getAllList();		// 전체 설비 리스트
	public List<FacilityVO> searchFac(String facCode);		// 설비 단건 조회
	public void insertFacility(FacilityVO upFac, FacilityVO downFac);		// 설비 등록 하는중
	public void modifyFac(FacilityVO vo);	// 설비 정보 수정
	
}
