package com.ptw.ptwProject.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class MultiKeyB implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer id1;
  private Integer id2;
}

/*
 * 복합키를 사용하기 위해서는 2가지 방법
 * 1.@IdClass는 객체지향적이기 보다, DB에 맞춘 방식이다.
 * 2.@EmbeddedId는 @IdClass보다 좀더 객체지향적인 방식이다
*/