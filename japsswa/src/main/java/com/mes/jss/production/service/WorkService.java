package com.mes.jss.production.service;

import java.util.List;

import com.mes.jss.basic.domain.BomVO;
import com.mes.jss.production.domain.SearchVO;
import com.mes.jss.production.domain.WorkVO;


public interface WorkService {
	
	// 작업지시 등록.
	public void workSave(WorkVO head, List<WorkVO> detailList);
	
	
	// 작업지시 조회 모달창 : 초기값 
	// 현재 날짜를 기준으로 일주일동안의 작업지시 조회 - 현재 날짜 포함, 현잰 날짜 전후로 3일
	public List<WorkVO> workResult();
	
	
	// 작업지시 조회 모달창 : 검색 결과 
	// 두 날짜 사이의 작업지시 내역 조회
	public List<WorkVO> workSearchResult(SearchVO vo);
	
	
	// 작업지시 관리 페이지 : 작업지시 세부내용 그리드에 입력
	// 작업지시 모달창에서 선택한 작업지시의 세부내용
	public List<WorkVO> workSelectDetail(String workId);
	
	
	// 작업지시 관리 페이지 : 제품별 BOM 및 공정 정보 조회
	// 제품명 더블클릭 -> 제품의 BOM 및 공정 정보 리스트
	public List<WorkVO> itemBomInfo(String wdetailId, String itemType);
	
	
	// 작업지시 공통 및 세부사항 삭제
	public boolean workDelete(String workId);
	
	
	// 작업지시 공통 및 세부사항 수정
	public void workModify(WorkVO head, List<WorkVO> detailList);
	
	
	// 홀드 자재 선택 모달창 : 자재 리스트
	// BOM정보 그리드에서 선택한 자재 리스트 출력.
	public List<WorkVO> selectHoldMaterial(String itemCode, String wdetailId);
	
	
	
	
	// 홀드 자재 등록 처리.
	// 1. 홀드 자재 등록
	// 2. 자재 홀드수량 더하기
	public void holdInsert(List<WorkVO> detailList);
	
	// 홀드 자재 수정 후 등록.
	// 1. 기존 홀드 자재 삭제
	// 2. 자재 홀드수량 빼주기
	// 3. 입력된 자재 등록 처리
	public void holdReInsert(List<WorkVO> detailList);
	
	
	// 공정이동표 조회 페이지
	// 작업지시 조회 모달 : 초기값
	public List<WorkVO> proMoveWorkModalList();
	
	// 작업지시 조회 모달 : 결과값
	public List<WorkVO> proMoveWorkModalResult(SearchVO vo);
	
	// 작업지시 상세 더블클릭 -> 해당 작업지시상세에 해당하는 공정현황 조회 
	public List<WorkVO> processCurrInfo(WorkVO vo);
	

}
