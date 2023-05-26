package com.mes.jss.material.service;

import java.util.List;

import com.mes.jss.material.domain.AdjustmentListVO;
import com.mes.jss.material.domain.DetaiListlVO;
import com.mes.jss.material.domain.MrAdjustmentVO;
import com.mes.jss.material.domain.MrOrderDetailVO;
import com.mes.jss.material.domain.MrOrderVO;
import com.mes.jss.material.domain.MrReturnVO;
import com.mes.jss.material.domain.MrVO;
import com.mes.jss.material.domain.ReturnListVO;
import com.mes.jss.quality.domain.QualityListVO;
import com.mes.jss.quality.domain.QualityVO;
import com.mes.jss.sale.domain.CustomerVO;

public interface MaterialService {

	public int mrStore(MrVO vo);
	
	// 자재 리스트
	public List<MrVO> mrlist();
	
	// 입고 검색
	public List<MrVO> searchList(String keyword);
	
	// 자재 재고
	public List<MrVO> mrCountList();
	
	// 자재 검색
	public List<MrVO> mrCount(String keyword);
	
	// 입고 처리
	public void mrIn(QualityListVO vo);
	
	// 거래처 리스트
	public List<CustomerVO> cusSearch();
	
	// 거래처 검색
	public List<CustomerVO> cusListSearch(String result);
	
	// 자재 발주
	public void orders(DetaiListlVO vo);
	
	// 자재 발주 조회
	public List<MrOrderVO> OrderMain();
	
	// 자재 발주 상세 조회
	public List<MrOrderDetailVO> OrderDetail(String keyword);
	
	// 자재 조정 리스트
	public List<MrAdjustmentVO> admList();
	
	// 자재 조정 될 리스트
	public List<MrAdjustmentVO> adList();
	
	// 자재 조정 등록
	public void admIn(AdjustmentListVO vo);
	
	// 자재 반품 품질 리스트
	public List<QualityVO> retList();
	
	// 자재 반품 리스트
	public List<MrReturnVO> returnList();
	
	// 자재 반품 등록
	public void returnIn(ReturnListVO vo);
	
	// 자재 조정 입고
	//public void adInsert(AdjustmentListVO vo);
}
