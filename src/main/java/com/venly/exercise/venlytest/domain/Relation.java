package com.venly.exercise.venlytest.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Relation {
  private Long id;
  @NotEmpty
  private String word1;
  @NotEmpty
  private String word2;
  @NotEmpty
  private String relation;

}
