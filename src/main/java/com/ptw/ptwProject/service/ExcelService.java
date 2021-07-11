package com.ptw.ptwProject.service;

import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
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
		
		XSSFWorkbook workbook = new XSSFWorkbook();  //xlsx 파일 생성
		XSSFSheet sheet = workbook.createSheet("twtest"); //시트 생성
		CellStyle cellStyle = workbook.createCellStyle(); // Cell 스타일 생성
		
		
		//배경색넣기
		cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//setFillForegroundColor ​속성만 해줘서는 안되고 setFillPattern SOLID_FOREGROUND 속성을 지정해줘야한다..


		XSSFRow row = null;
		XSSFCell cell = null;
		
		row = sheet.createRow(0); //첫행만들기
		String[] headerKey = {"회사번호", "회사명", "전화번호", "주소"}; //엑셀 칼럼명
		
		//헤더 생성
		for(int i=0; i<headerKey.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headerKey[i]);
			
			cell.setCellStyle(cellStyle);
		}
		
		//칼럼에 데이터 입력
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
