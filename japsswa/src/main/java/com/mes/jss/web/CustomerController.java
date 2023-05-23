package com.mes.jss.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mes.jss.basic.service.CommonService;
import com.mes.jss.basic.service.CustomerService;
import com.mes.jss.basic.service.impl.CommonServiceImpl;
import com.mes.jss.basic.service.impl.CustomerServiceImpl;

@Controller
public class CustomerController {
	@Autowired CustomerService cusService = new CustomerServiceImpl();
	@Autowired CommonService commService= new CommonServiceImpl();

	/*
	 * // 부분검색
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/customerList") public List<ItemVO>
	 * customerList(@RequestParam String val, String search){
	 * System.err.println(val); if(val == null || val.equals("null")) { return
	 * itemAllList(); }{ return cusService.getItemList(val); }
	 * 
	 * }
	 * 
	 * // 전체 리스트
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/cusAllList") public List<ItemVO> cusAllList(){
	 * 
	 * return cusService.getAllItemList(); }
	 * 
	 * 
	 * // 타임리프
	 * 
	 * @RequestMapping("/customer") public String customer(Model model){
	 * model.addAttribute("list",commService.getCustomerDeta()); return
	 * "basic/customer"; }
	 * 
	 * // 품목코드 불러오기
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/getCustomerId") public ItemVO getCustomerId() { ItemVO vo =
	 * cusService.getCustomerId(); return vo; }
	 * 
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/addCustomerAjax") public ItemVO
	 * addCustomerAjax(@RequestBody CustomerVO vo) { cusService.addCustomerAjax(vo);
	 * return vo; }
	 * 
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/modCustomerAjax") public ItemVO
	 * modCustomerAjax(@RequestBody CustomerVO vo) { System.err.println(vo);
	 * cusService.modCustomerAjax(vo); return vo; }
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/removeCustomer") public String removeCustomer(@RequestParam
	 * String customerId) {
	 * 
	 * if(cusService.removeCustomer(customerId)) { return "success"; }else { return
	 * "fail"; } }
	 */
	
}
