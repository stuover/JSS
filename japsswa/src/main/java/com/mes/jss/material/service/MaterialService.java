package com.mes.jss.material.service;

import java.util.List;

import com.mes.jss.basic.domain.CustomerVO;
import com.mes.jss.material.domain.AdjustmentListVO;
import com.mes.jss.material.domain.DetaiListVO;
import com.mes.jss.material.domain.MrAdjustmentVO;
import com.mes.jss.material.domain.MrErrorVO;
import com.mes.jss.material.domain.MrListVO;
import com.mes.jss.material.domain.MrOrderDetailVO;
import com.mes.jss.material.domain.MrOrderVO;
import com.mes.jss.material.domain.MrReleaseVO;
import com.mes.jss.material.domain.MrReturnVO;
import com.mes.jss.material.domain.MrVO;
import com.mes.jss.material.domain.ReturnListVO;
import com.mes.jss.production.domain.PerformanceListVO;
import com.mes.jss.production.domain.PerformanceVO;
import com.mes.jss.quality.domain.QualityListVO;
import com.mes.jss.quality.domain.QualityVO;

public interface MaterialService {
	
	public int mrStore(MrVO vo);
	
	// 자재 리스트
	public List<MrVO> mrlist();
	
	
	
	// 자재 재고 리스트(총)
	public List<MrVO> mrInvenList();
	
	// 자재 재고 리스트
	public List<MrVO> mrMatInven();
		
	// 반제품 재고 리스트
	public List<MrVO> mrHalfInven();
		
	// 검색 테스트
	public List<MrVO> mrSearchList();
		
	// 자재 안전 재고
	public List<MrVO> mrCountList();
	
	// 자재 lot 재고
	public List<MrVO> mrLotCountList();
	
	
	
	
	
	// 자재 검색
	public List<MrVO> mrCount(String keyword);
	
	// 입고 검색
	public List<MrVO> searchList(String keyword);
	
	// 입고 처리
	public void mrIn(QualityListVO vo);
	
	// 반제품 입고
	public void halfIn(PerformanceListVO vo);
		
	// 자재 입고 취소
	public void mrDelete(MrListVO vo);
	
	
	
	
	
	// 자재 입고 내역
	public List<MrVO> stList();
	
	// 자재 출고 내역
	public List<MrReleaseVO> mrRelGetList();
	
	
	
	
	
	
	// 거래처 리스트
	public List<CustomerVO> cusSearch();
	
	// 거래처 검색
	public List<CustomerVO> cusListSearch(String result);
	
	// 자재 발주
	public void orders(DetaiListVO vo);
	
	// 자재 발주 취소
	public void orderDel(DetaiListVO vo);
	
	// 자재 발주 조회
	public List<MrOrderVO> OrderMain();
	
	// 자재 발주 상세 조회
	public List<MrOrderDetailVO> OrderDetail(String keyword);
	
	
	
	
	
	// 자재 조정 리스트
	public List<MrAdjustmentVO> admList();
	
	// 자재 조정 될 리스트
	public List<MrAdjustmentVO> adList();
	
	// 자재 조정 찾기 리스트
	public List<MrAdjustmentVO> admSearchList();
	
	// 자재 조정 등록
	public void admIn(AdjustmentListVO vo);
	
	// 자재 조정 직접 등록
	public void admRealIn(AdjustmentListVO vo);
		
	// 자재 조정 입고
	public void admInsert(AdjustmentListVO vo);
	
	// 자재 조정 출고
	public void admRelease(AdjustmentListVO vo);
		
	// 자재 조정 취소
	public void admDel(AdjustmentListVO vo);
	
	// 자재 조정 수량 조정
	public void admCount(AdjustmentListVO vo);
	
	
	
	
	
	
	// 자재 반품 품질 리스트
	public List<QualityVO> retList();
	
	// 자재 반품 리스트
	public List<MrReturnVO> returnList();
	
	// 자재 반품 등록
	public void returnIn(ReturnListVO vo);
	
	// 자재 반품 취소
	public void returnDelete(ReturnListVO vo);
	
	
	
	
	
	
	
	// 자재 불량 리스트
	public List<MrErrorVO> ErrorList();
	
	// 생산 실적 리스트
	public List<PerformanceVO> mrPerformanceList();
	
	
	// 자재 재고 다중 검색
	public List<MrVO> MultiSearchList(MrVO vo);
	
	// 자재 입고 품질 사유 리스트
	public List<MrVO> mrQualityList();
	
	// 자재 입고 생산 사유 리스트
	public List<MrVO> mrProList();
	
	// 자재 입고 조정 사유 리스트
	public List<MrVO> mrAdmReasonList();
	
	// 자재 출고 생산 사유 리스트
	public List<MrVO> mrRelProList();
	
	// 자재 출고 조정 사유 리스트
	public List<MrVO> mrRelAdmList();
	
	
	// 자재 입고 내역 동적 쿼리 리스트
	public List<MrVO> mrStoreListQuery(MrVO vo);
	
	// 자재 lot 조회
	public List<MrVO> mrLot(String vo);
	
	// 자재 발주 조회용
	public List<MrOrderDetailVO> orderList();
	
	// 자재 출고 내역 검색
	public List<MrReleaseVO> mrRelSearch(MrReleaseVO vo);
	
	// 자재 반품 검색
	public List<MrReturnVO> mrReturnSearch(MrReturnVO vo);
	
	// 자재 조정 내역 리스트
	public List<MrAdjustmentVO> mrAdmFullList();
	
	// 자재 조정 내역 검색
	public List<MrAdjustmentVO> mrAdmSearch(MrAdjustmentVO vo);
	
	
	// 자재 입고 확인 검색
	public List<MrVO> mrStoreQuery(MrVO vo);
	
	// 거래처 자재 검색
	public List<CustomerVO> cusListQuery(CustomerVO vo);
	
	// 발주 조회용 리스트 검색
	public List<MrOrderVO> orderBeforeQuery(MrOrderVO vo);
	
	// 발주 내역 검색
	public List<MrOrderVO> ordersQuery(MrOrderVO vo);
	
	// 자재 조정 lot 검색
	public List<MrAdjustmentVO> mrLotSearch(MrAdjustmentVO vo);
	
	
	// 자재 조정 출고 입고량 가져오기
	public List<MrAdjustmentVO> admInRel(MrAdjustmentVO vo);
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	

	
	
	
}
