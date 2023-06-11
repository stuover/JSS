package com.mes.jss.production.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mes.jss.production.domain.SearchVO;
import com.mes.jss.production.domain.WorkVO;
import com.mes.jss.production.mapper.WorkMapper;
import com.mes.jss.production.service.WorkService;

@Service
public class WorkServiceImpl implements WorkService {
	
	@Autowired WorkMapper workMapper;
	
	
	// 작업지시 등록.
	@Override
	@Transactional
	public void workSave(WorkVO head, List<WorkVO> detailList) {
		workMapper.workCommonSave(head);
		
		for(WorkVO detail : detailList) {
			detail.setWorkId(head.getWorkId());
			workMapper.workDetailSave(detail);
			workMapper.workBomInsert(detail.getWdetailId(), detail.getItemType(), detail.getItemCode());
		}
		
	}

	
	// 작업지시 조회 모달창 : 초기값 
	// 현재 날짜를 기준으로 일주일동안의 작업지시 조회 - 현재 날짜 포함, 현잰 날짜 전후로 3일
	@Override
	public List<WorkVO> workResult() {
		List<WorkVO> list = new ArrayList<>();
		list = workMapper.workResult();
		System.err.println(list);
		return list;
	}

	
	// 작업지시 조회 모달창 : 검색 결과 
	// 두 날짜 사이의 작업지시 내역 조회
	@Override
	public List<WorkVO> workSearchResult(SearchVO vo) {
		List<WorkVO> list = new ArrayList<>();
		list = workMapper.workSearchResult(vo);
		return list;
	}

	
	// 작업지시 관리 페이지 : 작업지시 세부내용 그리드에 입력
	// 작업지시 모달창에서 선택한 작업지시의 세부내용
	@Override
	public List<WorkVO> workSelectDetail(String workId) {
		List<WorkVO> list = new ArrayList<>();
		list = workMapper.workSelectDetail(workId);
		return list;
	}

	
	// 작업지시 관리 페이지 : 제품별 BOM 및 공정 정보 조회
	// 제품명 더블클릭 -> 제품의 BOM 및 공정 정보 리스트
	@Override
	public List<WorkVO> itemBomInfo(String wdetailId, String itemType) {
		List<WorkVO> list = new ArrayList<>();
		list = workMapper.itemBomInfo(wdetailId, itemType);
		return list;
	}

	// 작업지시 공통 및 세부사항 삭제
	@Override
	public void workDelete(String id) {
		
		workMapper.workDelete(id);
		  
	}

	// 작업지시 공통 및 세부사항 수정
	@Override
	public void workModify(WorkVO head, List<WorkVO> detailList) {
		// 작업지시코드로 기존의 데이터 삭제.
		String id = head.getWorkId();
		workMapper.workDelete(id);
		
		// 입력된 데이터로 작업지시 공통 및 상세 재등록.
		workMapper.workCommonSave(head);
		
		for(WorkVO detail : detailList) {
			detail.setWorkId(head.getWorkId());
			workMapper.workDetailSave(detail);
		}
		
	}

	// 홀드 자재 선택 모달창 : 자재 리스트
	// BOM정보 그리드에서 선택한 자재 리스트 출력.
	@Override
	public List<WorkVO> selectHoldMaterial( String itemCode, String wdetailId) {
		List<WorkVO> list = workMapper.selectHoldMaterial(itemCode, wdetailId);
		
		return list;
	}


	// 홀드 자재 등록 처리.
	// 1. 홀드 자재 등록
	// 2. 자재 홀드수량 더하기
	@Override
	@Transactional
	public void holdInsert(List<WorkVO> detailList) {
		
		for(WorkVO info : detailList) {
			// 1. 홀드 자재 등록
			workMapper.holdMaterialInsert(info);
			
			// 2. 자재 홀드수량 더하기
			workMapper.holdMaterialAdd(info);
		}
		
	}


	// 홀드 자재 수정 후 등록.
	// 1. 기존 홀드 자재 삭제
	// 2. 자재 홀드수량 빼주기
	// 3. 입력된 자재 등록 처리
	@Override
	@Transactional
	public void holdReInsert(List<WorkVO> detailList) {
		// 1. 기존 홀드 자재 삭제
		WorkVO obj = new WorkVO();
		obj.setWdetailId(detailList.get(0).getWdetailId());
		obj.setProCode(detailList.get(0).getProCode());
		obj.setItemCode(detailList.get(0).getItemCode());
		
		workMapper.holdMaterialDelete(obj);
		
		for(WorkVO info : detailList) {
			// 2. 자재 홀드수량 빼주기
			workMapper.holdMaterialMinus(info);		
		}
		
		for(WorkVO info : detailList) {
			// 3. 홀드 자재 등록
			workMapper.holdMaterialInsert(info);
			
			// 4. 자재 홀드수량 더하기
			workMapper.holdMaterialAdd(info);
		}
		
	}


	// 공정이동표 조회 페이지
	// 작업지시 조회 모달 : 초기값
	@Override
	public List<WorkVO> proMoveWorkModalList() {
		List<WorkVO> list = workMapper.proMoveWorkModalList();
				
		return list;
	}


	// 작업지시 조회 모달 : 결과값
	@Override
	public List<WorkVO> proMoveWorkModalResult(SearchVO vo) {
		List<WorkVO> list = workMapper.proMoveWorkModalResult(vo);
		
		return list;
	}


	// 작업지시 상세 더블클릭 -> 해당 작업지시상세에 해당하는 공정현황 조회
	@Override
	public List<WorkVO> processCurrInfo(WorkVO vo) {
		List<WorkVO> list = workMapper.processCurrInfo(vo);
		
		return list;
	}


	// 생산실적 등록 페이지 : 선택한 작업지시의 세부 내용
	@Override
	public List<WorkVO> perforWorkDetailReuslt(String workId) {
		List<WorkVO> list = workMapper.perforWorkDetailReuslt(workId);
		return list;
	}

	
	



}
