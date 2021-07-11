package com.ptw.ptwProject;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ptw.ptwProject.model.ExportExcel;
import com.ptw.ptwProject.persistence.ExcelRepository;


@SpringBootTest
public class PtwTest {
	
	@Autowired
	ExcelRepository excelrepo;

	//@Test
	public void insertCompany() {
		IntStream.range(3,101).forEach(i->{
			ExportExcel b = new ExportExcel();
			b.setCompanyNo(1L+i);
			b.setCompany("회사이름" + i);
			b.setPhone("010-000-" + i);
			b.setAddress("금천구 가산동" + i%10);
			excelrepo.save(b);
		});
	}
}
