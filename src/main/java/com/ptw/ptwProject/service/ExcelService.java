package com.ptw.ptwProject.service;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptw.ptwProject.model.ExportExcel;
import com.ptw.ptwProject.persistence.ExcelRepository;

@Service
public class ExcelService {

	@Autowired
	ExcelRepository excelrepo;

	public List<ExportExcel> selectAll(){
		return (List<ExportExcel>)excelrepo.findAll();
	}
	
	public XSSFWorkbook listExcelDownload(List<ExportExcel> list) throws Exception {
		
		XSSFWorkbook workbook = new XSSFWorkbook();  
		XSSFSheet sheet = workbook.createSheet("twtest"); 
		XSSFRow row = null;
		XSSFCell cell = null;
		
		row = sheet.createRow(0);
		String[] headerKey = {"회사번호", "회사명", "전화번호", "주소"}; //엑셀 칼럼명
		
		for(int i=0; i<headerKey.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headerKey[i]);
		}
		
		for(int i=0; i<list.size(); i++) {
			row = sheet.createRow(i + 1);
			ExportExcel vo = list.get(i);
			
			cell = row.createCell(0);
			cell.setCellValue(vo.getCompanyNo());
			cell = row.createCell(1);
			cell.setCellValue(vo.getCompany());
			cell = row.createCell(2);
			cell.setCellValue(vo.getPhone());
			cell = row.createCell(3);
			cell.setCellValue(vo.getAddress());

		}
		return workbook;
	}
}
