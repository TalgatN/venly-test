package com.venly.exercise.venlytest.domain;

import jakarta.validation.constraints.NotEmpty;
import java.util.Objects;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Relation relation1)) {
      return false;
    }
    return Objects.equals(word1, relation1.word1) && Objects.equals(word2,
        relation1.word2) && Objects.equals(relation, relation1.relation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(word1, word2, relation);
  }
}
