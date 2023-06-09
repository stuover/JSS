package com.mes.jss.production.mapper;

import java.util.List;

import com.mes.jss.basic.domain.BomVO;
import com.mes.jss.basic.domain.ProcessOrderVO;
import com.mes.jss.production.domain.SearchVO;
import com.mes.jss.production.domain.WorkVO;

public interface WorkMapper {
	
	// 작업지시 등록.
	// 작업지시 공통사항 등록처리.
	public WorkVO workCommonSave(WorkVO vo);
	// 작업지시 세부사항 등록처리.
	public WorkVO workDetailSave(WorkVO vo);
	// 지시 공정 정보 등록
	public WorkVO workBomInsert(String wdetailId, String itemType, String itemCode);
	
	
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
	public void workDelete(String id);
	
	
	// 홀드 자재 선택 모달창 : 자재 리스트
	// BOM정보 그리드에서 선택한 자재 리스트 출력.
	public List<WorkVO> selectHoldMaterial(String itemCode, String wdetailId);
	
	
	// 홀드 자재 등록.
	// 홀드 자재 등록
	public WorkVO holdMaterialInsert(WorkVO vo);
	// 자재 홀드수량 더하기
	public WorkVO holdMaterialAdd(WorkVO vo);
	
	// 홀드 자재 삭제
	public WorkVO holdMaterialDelete(WorkVO vo);
	// 자재 홀드수량 빼주기
	public WorkVO holdMaterialMinus(WorkVO vo);
	
	
	// 공정이동표 조회 페이지
	// 작업지시 조회 모달 : 초기값
	public List<WorkVO> proMoveWorkModalList();
	
	// 작업지시 조회 모달 : 결과값
	public List<WorkVO> proMoveWorkModalResult(SearchVO vo);
	
	// 작업지시 상세 더블클릭 -> 해당 작업지시상세에 해당하는 공정현황 조회 
	public List<WorkVO> processCurrInfo(WorkVO vo);
	
	
	// 생산실적 등록 페이지 : 선택한 작업지시의 세부 내용
	public List<WorkVO> perforWorkDetailReuslt(String workId);
	
	
}
