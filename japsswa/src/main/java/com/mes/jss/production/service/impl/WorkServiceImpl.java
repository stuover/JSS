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
	public List<WorkVO> itemBomInfo(String ingCode, String itemType) {
		List<WorkVO> list = new ArrayList<>();
		list = workMapper.itemBomInfo(ingCode, itemType);
		return list;
	}

	// 작업지시 공통 및 세부사항 삭제
	@Override
	public boolean workDelete(String workId) {
		boolean result = workMapper.workDelete(workId)>0;
		return result;  
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
	public List<WorkVO> selectHoldMaterial(String itemCode) {
		List<WorkVO> list = workMapper.selectHoldMaterial(itemCode);
		
		return list;
	}
	
	


}
