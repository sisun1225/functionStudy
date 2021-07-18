package com.ptw.ptwProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NaverController {

	//유저가 요청하면 일단 메인페이지 보여주는 컨트롤....
	@RequestMapping("/searchview")
	public String test() {
		return "naversearcch/searchstore";
	}
}
