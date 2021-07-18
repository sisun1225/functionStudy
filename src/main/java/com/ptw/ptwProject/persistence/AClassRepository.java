package com.ptw.ptwProject.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptw.ptwProject.model.MultiKeyA;
import com.ptw.ptwProject.model.MultiKeyAClass;

public interface AClassRepository 
    extends JpaRepository<MultiKeyAClass, MultiKeyA>{

	 
}
 