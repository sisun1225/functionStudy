package com.ptw.ptwProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_ExcelTest")

public class ExportExcel {
	
	@Id
	Long companyNo;
	
	String company;
	String phone;
	String address;
}
