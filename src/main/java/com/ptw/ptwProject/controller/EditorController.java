package com.ptw.ptwProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditorController {
	
	@GetMapping("/editor")
	public String editor() {
		return "editor.html";
	}

}
