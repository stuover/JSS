package com.mes.jss.material.mapper;

import java.util.List;

import com.mes.jss.basic.domain.CustomerVO;
import com.mes.jss.material.domain.MrAdjustmentVO;
import com.mes.jss.material.domain.MrErrorVO;
import com.mes.jss.material.domain.MrOrderDetailVO;
import com.mes.jss.material.domain.MrOrderVO;
import com.mes.jss.material.domain.MrReleaseVO;
import com.mes.jss.material.domain.MrReturnVO;
import com.mes.jss.material.domain.MrVO;
import com.mes.jss.production.domain.PerformanceVO;
import com.mes.jss.quality.domain.QualityVO;

public interface MaterialMapper {
	
	public int insert(MrVO vo);
	
	// 자재 조회
	
	public List<MrVO> getList();	
	
	// 코드 검색
	public List<MrVO> codeList(String keyword);
	
	
	// 자재 안전 재고
	public List<MrVO> getMrCount();	
	
	// 자재 재고 리스트(총)
	public List<MrVO> mrInvenCount();
	
	// 자재 재고 리스트
	public List<MrVO> matInven();
	
	// 반제품 리스트
	public List<MrVO> halfInven();
		
	
	// 자재 lot 재고
	public List<MrVO> getMrLotCount();
	
	// 자재명 검색
	public List<MrVO> mrCountList(String keyword);
	
	// 입고 처리
	public void StoreIn(String testCode);
	
	// 입고 취소
	public void deleteMr(String mrLotNumber);
	
	// 자재 입고 내역
	public List<MrVO> storeGetList();

	// 자재 출고 내역
	public List<MrReleaseVO> RelGetList();
	
	
	// 생산 실적 리스트
	public List<PerformanceVO> mrPerList();
		
	// 반제품 입고
	public void halfInsert(PerformanceVO vo);
	
	// 거래처 리스트
	public List<CustomerVO> customerList();
	
	// 거래처 검색
	public List<CustomerVO> searchcustomer(String result);

	// 발주 상세 등록
	public void orderInsert(MrOrderDetailVO mrOrderDetailVO);
	
	// 발주 등록
	public void mrorderInsert(String result);
	
	// 발주 취소
	public void mrOrderDelete(String mrOrderCode);
	
	// 발주 조회
	public List<MrOrderVO> OrmGetList();
	
	// 발주 상세
	public List<MrOrderDetailVO> OrdGetList(String keyword);
	
	// 자재 조정 리스트
	public List<MrAdjustmentVO> admGetList();
	
	// 자재 조정 될 리스트
	public List<MrAdjustmentVO> mrAdGetList();
	
	// 자재 조정 등록
	public void adjInsert(MrAdjustmentVO vo);
	
	// 자재 조정 입고
	public void admInsert(MrAdjustmentVO vo);
	
	// 자재 조정 출고
	public void adjRelease(MrAdjustmentVO vo);
	
	// 자재 조정 취소
	public void admDelete(String vo);
	
	
	// 자재 반품 품질 리스트
	public List<QualityVO> retGetList();
	
	// 자재 반품 리스트
	public List<MrReturnVO> returnGetList();
	
	// 자재 반품 등록
	public List<MrReturnVO> returnInsert(MrReturnVO vo);
	
	// 자재 반품 취소
	public void returnDel(String mrReturnCode);
	
	// 자재 불량 리스트
	public List<MrErrorVO> ErrorGetList();
	
	// 자재 검색 테스트
	public List<MrVO> searchMr();
	
	// 자재 조정 직접 등록
	public void realIn(String keyword);

	
	
	
	

	
	
	
	

	
	
	
	
	

	

}
