package com.mes.jss.material.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mes.jss.material.domain.DetaiListlVO;
import com.mes.jss.material.domain.MrAdjustmentVO;
import com.mes.jss.material.domain.MrOrderDetailVO;
import com.mes.jss.material.domain.MrOrderVO;
import com.mes.jss.material.domain.MrVO;
import com.mes.jss.material.mapper.MaterialMapper;
import com.mes.jss.material.service.MaterialService;
import com.mes.jss.sale.domain.CustomerVO;

@Service("materialService")
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	private MaterialMapper materialMapper;

	// 자재 조회
	
	@Override
	public List<MrVO> mrlist() {
		
		return materialMapper.getList();
	}
	
	// 자재 재고 검색
	
	@Override
	public List<MrVO> mrCount(String keyword) {
		
		return materialMapper.mrCountList(keyword);
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
	public MrVO mrIn(String testCode) {

		return materialMapper.StoreIn(testCode);
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
	public void orders(DetaiListlVO vo) {

		materialMapper.mrorderInsert(vo.getList().get(0).getCustomerId());
		
		for (int i = 0; i < vo.getList().size(); i++) {
			materialMapper.orderInsert(vo.getList().get(i));
			
			System.err.println(vo.getList().get(i));
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
	
	

}
