package com.ptw.ptwProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_child1")
@IdClass(MultiKeyA.class)
public class MultiKeyAClass {

    @Id
	private Integer id1;
    @Id
	private Integer id2;
    
    private String name;
 
}
