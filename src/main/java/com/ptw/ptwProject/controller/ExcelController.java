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

				response.reset(); //ContentType등을 동적으로 바꾸기 위해 초기화시킴
				response.setHeader("Content-Disposition", "attachment;filename=kosta_history.xlsx"); // 엑셀 파일 명
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); //잘못지정하면 브라우저에따라 문제 발생가능 
							//MIME 타입이란 클라이언트에게 전송된 문서의 다양성을 알려주기 위한 메커니즘입니다: 
							//웹에서 파일의 확장자는 별  의미가 없습니다. 그러므로, 각 문서와 함께 올바른 MIME 타입을 전송하도록, 
							//서버가 정확히 설정하는 것이 중요합니다. 브라우저들은 리소스를 내려받았을 때 해야 할 기본 동작이 무엇인지를 결정하기 위해 대게 MIME 타입을 사용합니다.
			
				out = new BufferedOutputStream(response.getOutputStream());
				workbook.write(out);
				out.flush();

			} catch (Exception e) {
				e.printStackTrace();  //에러의 발생근원지를 찾아서 단계별로 에러를 출력합니다.
			}
		}


	
	@RequestMapping(value = "/excelTest2", method =  RequestMethod.GET)
	public String test2() {
		return "excelTest";
	}
	

}
