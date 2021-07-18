package com.ptw.ptwProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ptw.ptwProject.model.MultiKeyA;
import com.ptw.ptwProject.model.MultiKeyAClass;
import com.ptw.ptwProject.service.AClassService;

//복합키 사용 상황 : 주문 + 아이템번호 = 주문상세table키
/*
 주문이 있는데 주문 하나의 테이블에 주문에 대한 상세 내역 테이블이 따로있는데 
그 상세 테이블은 키가 합쳐져있는것이다. 

*/

@Controller
public class AClassController {
	@Autowired
	AClassService service;
	
	@RequestMapping("/insert")
	public String insert() {
		service.insert();
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String test1(Model model) {
		model.addAttribute("alist", service.findAll());
		return "aclass_list";
	}
	@GetMapping("/adetail")
	public String test2(Model model, Integer id1, Integer id2) {
		MultiKeyA id = MultiKeyA.builder()
				.id1(id1)
				.id2(id2)
				.build();
		//System.out.println(id);
		//System.out.println(service.findById(id));
		model.addAttribute("vo", service.findById(id));
		return "aclass_detail";
	}
	@PostMapping("/adetail")
	public String test3(MultiKeyAClass aclass) {
		service.update(aclass);
		return "redirect:/list";
	}
	@GetMapping("/delete")
	public String test3(MultiKeyA akey) {
		System.out.println(akey);
		service.delete(akey);
		return "redirect:/list";
	}
	
	@GetMapping("/naverSearch")
	public void search() {
		
	}
	
	
}






