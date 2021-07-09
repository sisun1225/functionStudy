package com.ptw.ptwProject.persistence;

import org.springframework.data.repository.CrudRepository;

import com.ptw.ptwProject.model.ExportExcel;

public interface ExcelRepository extends CrudRepository<ExportExcel, Long>{
	
	

}
