package com.ptw.ptwProject.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_child2")
public class MultiKeyBClass {
    @EmbeddedId
	private MultiKeyB id;
    private String name;
 
}
