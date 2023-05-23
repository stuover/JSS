package com.mes.jss.material.mapper;

import java.util.List;

import com.mes.jss.material.domain.MrAdjustmentVO;
import com.mes.jss.material.domain.MrOrderDetailVO;
import com.mes.jss.material.domain.MrOrderVO;
import com.mes.jss.material.domain.MrVO;
import com.mes.jss.sale.domain.CustomerVO;

public interface MaterialMapper {
	
	public int insert(MrVO vo);
	
	// 자재 조회
	
	public List<MrVO> getList();	
	
	// 코드 검색
	public List<MrVO> codeList(String keyword);
	
	// 자재명 검색
	public List<MrVO> mrCountList(String keyword);
	
	// 입고 처리
	public MrVO StoreIn(String testCode);
	
	// 거래처 리스트
	public List<CustomerVO> customerList();
	
	// 거래처 검색
	public List<CustomerVO> searchcustomer(String result);

	// 발주 상세 등록
	public void orderInsert(MrOrderDetailVO mrOrderDetailVO);
	
	// 발주 등록
	public void mrorderInsert(String result);
	
	// 발주 조회
	public List<MrOrderVO> OrmGetList();
	
	// 발주 상세
	public List<MrOrderDetailVO> OrdGetList(String keyword);
	
	// 자재 조정 리스트
	public List<MrAdjustmentVO> admGetList();
}
