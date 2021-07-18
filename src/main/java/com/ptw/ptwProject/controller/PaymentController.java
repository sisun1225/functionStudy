package com.ptw.ptwProject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ptw.ptwProject.service.ReqPaymentScheduler;
import com.ptw.ptwProject.service.RequestSubPayment;



@Controller
public class PaymentController {
	
	@Autowired
	RequestSubPayment reqSubpay;
	@Autowired
	ReqPaymentScheduler scheduler;
	@GetMapping("/test")
	public void packlist(Model model) {
		
		
	}
	
	
	@PostMapping("/payment")
	public @ResponseBody void getImportToken(@RequestParam Map<String, Object> map)
			throws JsonMappingException, JsonProcessingException {
		long customer_uid = Long.parseLong((String) map.get("customer_uid"));
		int price = Integer.parseInt((String) map.get("price"));
		long merchant_uid =  Long.parseLong((String) map.get("merchant_uid"));  
		long packageId =  Long.parseLong((String) map.get("packageId"));  
	
		reqSubpay.requestSubPay(customer_uid,merchant_uid, price);
		scheduler.startScheduler(customer_uid,price,packageId);

		}
	
	
	
}
