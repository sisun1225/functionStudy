package com.ptw.ptwProject.controller;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptw.ptwProject.model.ExportExcel;
import com.ptw.ptwProject.persistence.ExcelRepository;
import com.ptw.ptwProject.service.ExcelService;

@Controller
public class ExcelController {
	
	@Autowired
	ExcelService excelservice;
	

	@RequestMapping("/excelTest")
	public void adminList(Model model, HttpServletRequest request) {
		List<ExportExcel> result = excelservice.selectAll();
		model.addAttribute("excellist", result);
	}

	@Autowired
	ExcelRepository excelrepository;
	
	//강의내역 엑셀다운로드
		@RequestMapping("/exceldownload")
		public void excelDownload(Model model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) throws Exception {

			OutputStream out = null;

			try {
				List<ExportExcel> list = (List<ExportExcel>) excelrepository.findAll();

				XSSFWorkbook workbook = excelservice.listExcelDownload(list);

				response.reset();
				response.setHeader("Content-Disposition", "attachment;filename=kosta_history.xls"); // 엑셀 파일 명
				response.setContentType("application/vnd.ms-excel");
				out = new BufferedOutputStream(response.getOutputStream());

				workbook.write(out);
				out.flush();

			} catch (Exception e) {
				// logger.error("exception during downloading excel file : {}", e);
			} finally {
				if (out != null)
					out.close();
			}
		}


	
	@RequestMapping(value = "/excelTest2", method =  RequestMethod.GET)
	public String test2() {
		
		return "excelTest";
	}
	

}
