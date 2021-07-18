package com.ptw.ptwProject.service;



import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptw.ptwProject.model.MultiKeyA;
import com.ptw.ptwProject.model.MultiKeyAClass;
import com.ptw.ptwProject.persistence.AClassRepository;

@Service
public class AClassService {

	@Autowired
	AClassRepository repo;
	
	public void insert() {
		IntStream.range(1, 6).forEach(i->{
			MultiKeyAClass vo = MultiKeyAClass.builder()
					.id1(i)
					.id2(i)
					.name("복합키연습"+i)
					.build();
			repo.save(vo);
		});
 
	}
	
	public MultiKeyAClass update(MultiKeyAClass vo) {
		return repo.save(vo);
	}
	
	public void delete(MultiKeyA key) {
		repo.deleteById(key); 
	}
	public List<MultiKeyAClass> findAll() {
		return repo.findAll();
	}
	public MultiKeyAClass findById(MultiKeyA id) {
		return repo.findById(id).orElse(null);
	}
}
