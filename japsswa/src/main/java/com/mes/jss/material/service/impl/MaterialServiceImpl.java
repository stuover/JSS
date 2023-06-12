package com.mes.jss.material.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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
import com.mes.jss.material.mapper.MaterialMapper;
import com.mes.jss.material.service.MaterialService;
import com.mes.jss.production.domain.PerformanceListVO;
import com.mes.jss.production.domain.PerformanceVO;
import com.mes.jss.quality.domain.QualityListVO;
import com.mes.jss.quality.domain.QualityVO;

@Service("materialService")
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	private MaterialMapper materialMapper;

	// 자재 조회
	
	@Override
	public List<MrVO> mrlist() {
		
		return materialMapper.getList();
	}
	
	// 자재 안전 재고 
	@Override
	public List<MrVO> mrCountList() {
		
		return materialMapper.getMrCount();
	}
	
	// 자재 재고(총)
	@Override
	public List<MrVO> mrInvenList() {
		
		return materialMapper.mrInvenCount();
	}
	
	// 반제품 재고 리스트
	@Override
	public List<MrVO> mrHalfInven() {
		
		return materialMapper.halfInven();
	}

	// 자재 재고 리스트
	@Override
	public List<MrVO> mrMatInven() {
		
		return materialMapper.matInven();
	}

	
	
	
	
	// 자재 lot 재고 리스트
	@Override
	public List<MrVO> mrLotCountList() {
		
		return materialMapper.getMrLotCount();
	}
	
	// 자재 재고 검색
	
	@Override
	public List<MrVO> mrCount(String keyword) {
		
		return materialMapper.mrCountList(keyword);
	}
	
	// 자재 입고 내역
	@Override
	public List<MrVO> stList() {
		
		return materialMapper.storeGetList();
	}
	
	// 자재 출고 내역
		@Override
		public List<MrReleaseVO> mrRelGetList() {
			
			return materialMapper.RelGetList();
		}

	
	
	
	// 자재 입고
	
	@Override
	public int mrStore(MrVO vo) {
			
		
		return materialMapper.insert(vo);
	}
	
	

	
	// 입고 확인 검색
	
	@Override
	public List<MrVO> searchList(String keyword) {

		return materialMapper.codeList(keyword);
	}
	
	
	// 자재 입고 
	
	@Override
	@Transactional
	public void mrIn(QualityListVO vo) {
		
		for(int i=0;  i< vo.getList().size(); i++) {
			materialMapper.StoreIn(vo.getList().get(i).getTestCode());
		}
		
	}
	
	// 자재 입고 취소
	@Override
	public void mrDelete(MrListVO vo) {
		
		for(int i=0; i<vo.getList().size(); i++) {
			materialMapper.deleteMr(vo.getList().get(i).getMrLotNumber());
		}
		
	}
	
	// 생산 실적 리스트
		@Override
		public List<PerformanceVO> mrPerformanceList() {
			
			return materialMapper.mrPerList();
		}
	
	// 반제품 입고	
		@Override
		public void halfIn(PerformanceListVO vo) {
			
			for(int i=0; i<vo.getList().size(); i++) {
				materialMapper.halfInsert(vo.getList().get(i));
			}
			
		}	
		
		
		
	// 거래처 리스트
	
	@Override
	public List<CustomerVO> cusSearch() {

		return materialMapper.customerList();
	}

	// 거래처 검색
	
	@Override
	public List<CustomerVO> cusListSearch(String result) {

		return materialMapper.searchcustomer(result);
	}
	
	// 자재 발주 
	
	@Override
	@Transactional
	public void orders(DetaiListVO vo) {

		materialMapper.mrorderInsert(vo.getList().get(0).getCustomerId());
		
		for (int i = 0; i < vo.getList().size(); i++) {
			materialMapper.orderInsert(vo.getList().get(i));
			
			System.err.println(vo.getList().get(i));
		}

	}
	
	// 자재 발주 취소
	
	@Override
	public void orderDel(DetaiListVO vo) {
		
		for(int i=0; i<vo.getList().size(); i++) {
			
			materialMapper.mrOrderDelete(vo.getList().get(i).getMrOrderCode());
		}
		
	}
	
	
	// 자재 발주 리스트
		@Override
		public List<MrOrderVO> OrderMain() {
			
			
			return materialMapper.OrmGetList();
		}
		// 자재 발주 상세 리스트
		
		@Override
		public List<MrOrderDetailVO> OrderDetail(String keyword) {
			
			return materialMapper.OrdGetList(keyword);
		}
	

	// 자재 조정 리스트
	
	@Override
	public List<MrAdjustmentVO> admList() {
		
		return materialMapper.admGetList();
	}
	
	// 자재 조정 될 리스트
	@Override
	public List<MrAdjustmentVO> adList() {
		
		return materialMapper.mrAdGetList();
	}
	
	// 자재 조정 찾기 리스트
	@Override
	public List<MrAdjustmentVO> admSearchList() {
		
		return materialMapper.mrAdSearch();
	}
	
	
	// 자재 조정 입고
	@Override
	public void admIn(AdjustmentListVO vo) {
		for(int i=0; i<vo.getList().size(); i++) {
			
			materialMapper.adjInsert(vo.getList().get(i));
		}
		
	}
	
	// 자재 조정 출고
	@Override
	public void admRelease(AdjustmentListVO vo) {
		
		for(int i=0; i<vo.getList().size(); i++) {
			
			materialMapper.adjRelease(vo.getList().get(i));
		}
		
	}
	
	// 자재 조정 등록
	@Override
	public void admInsert(AdjustmentListVO vo) {
		
		for(int i=0; i<vo.getList().size(); i++) {
			
			materialMapper.admInsert(vo.getList().get(i));
		}
	}
	
	// 자재 조정 취소
		@Override
		public void admDel(AdjustmentListVO vo) {
			
			for(int i=0; i<vo.getList().size(); i++) {
				
				materialMapper.admDelete(vo.getList().get(i).getAdjustmentCode());
			}
			
		}
	
	// 반품 품질 리스트
	@Override
	public List<QualityVO> retList() {
		
		return materialMapper.retGetList();
	}
	
	// 반품 리스트
	@Override
	public List<MrReturnVO> returnList() {
		
		return materialMapper.returnGetList();
	}
	
	// 반품 등록
	@Override
	public void returnIn(ReturnListVO vo) {
		
		for(int i=0; i<vo.getList().size(); i++) {
			
			materialMapper.returnInsert(vo.getList().get(i));
		}
		
	}
	// 자재 반품 삭제
			
		
	@Override
	public void returnDelete(ReturnListVO vo) {
		
		for(int i=0; i<vo.getList().size(); i++) {
			
			materialMapper.returnDel(vo.getList().get(i).getMrReturnCode());
		}
		
	}
	// 자재 불량 리스트
	@Override
	public List<MrErrorVO> ErrorList() {
		
		return materialMapper.ErrorGetList();
	}

	@Override
	public List<MrVO> mrSearchList() {
		
		return materialMapper.searchMr();
	}

	@Override
	public void admRealIn(AdjustmentListVO vo) {
		
		
		for(int i=0; i<vo.getList().size(); i++) {
			materialMapper.realIn(vo.getList().get(i).getMrLotNumber());
		}
		
	}
	
	//자재 조정 수량 조정
	
	@Override
	public void admCount(AdjustmentListVO vo) {
		
		for(int i=0; i<vo.getList().size(); i++) {
			materialMapper.admCountChange(vo.getList().get(i));
		}
		
	}
	
	
	// 자재 다중 검색 처리
	
	
	@Override
	public List<MrVO> MultiSearchList(MrVO vo) {
		
		
		return materialMapper.MrCountMulti(vo);
	}
	
	
	// 품질 사유 리스트 
	@Override
	public List<MrVO> mrQualityList() {
		
		return materialMapper.MrQuality();
	}
	
	// 생산 사유 리스트
	@Override
	public List<MrVO> mrProList() {
		
		return materialMapper.MrPro();
	}
	
	// 조정 사유 리스트
	@Override
	public List<MrVO> mrAdmReasonList() {
		
		return materialMapper.MrAdm();
	}

	@Override
	public List<MrVO> mrRelProList() {
		
		return materialMapper.MrRelPro();
	}
	
	
	@Override
	public List<MrVO> mrRelAdmList() {
		return materialMapper.MrRelAdm();
	}
	
	// 자재 입고 내역 검색 동적 쿼리
	@Override
	public List<MrVO> mrStoreListQuery(MrVO vo) {
		
		return materialMapper.MrStoreList(vo);
	}

	@Override
	public List<MrVO> mrLot(String itemName) {
		
		return materialMapper.MrLotList(itemName);
	}

	//발주 조회용
	@Override
	public List<MrOrderDetailVO> orderList() {
		
		return materialMapper.MrOrmGetList();
	}
	
	//자재 출고 검색
	@Override
	public List<MrReleaseVO> mrRelSearch(MrReleaseVO vo) {
		
		return materialMapper.MrRelQuery(vo);
	}
	
	//자재 반품 검색
	@Override
	public List<MrReturnVO> mrReturnSearch(MrReturnVO vo) {
		
		return materialMapper.MrRetQuery(vo);
	}
	
	
	// 자재 조정 내역 리스트
	@Override
	public List<MrAdjustmentVO> mrAdmFullList() {
		
		return materialMapper.mrAdmFull();
	}
	
	// 자재 조정 내역 검색
	@Override
	public List<MrAdjustmentVO> mrAdmSearch(@RequestBody MrAdjustmentVO vo) {
		
		System.err.println(vo);
		return materialMapper.mrAdmSearchQuery(vo);
	}
	
	// 자재 입고 확인 검색
	@Override
	public List<MrVO> mrStoreQuery(MrVO vo) {
		
		return materialMapper.mrStoreQuery(vo);
	}

	@Override
	public List<CustomerVO> cusListQuery(CustomerVO vo) {
		
		return materialMapper.cusMrQuery(vo);
	}
	
	//발주 조회용 리스트 검색
	
	@Override
	public List<MrOrderVO> orderBeforeQuery(MrOrderVO vo) {
		
		return materialMapper.orderBeforeDelete(vo);
	}
	
	//발주 내역 검색 
	@Override
	public List<MrOrderVO> ordersQuery(MrOrderVO vo) {
		
		return materialMapper.ordersSearch(vo);
	}

	@Override
	public List<MrAdjustmentVO> mrLotSearch(MrAdjustmentVO vo) {
		
		return materialMapper.mrAdmLot(vo);
	}

	
	
	
	
	

		
	}
	
	

	
	
	
	

	

	

	

	
	
	

	

	

	


	
	
	

	
	


