package com.ptw.ptwProject.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MultiKeyA implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer id1;
  private Integer id2;
  
}

/*
 * 복합키를 사용하기 위해서는 2가지 방법
 * A.@IdClass는 객체지향적이기 보다, DB에 맞춘 방식이다.
 * B.@EmbeddedId는 @IdClass보다 좀더 객체지향적인 방식이다
*/