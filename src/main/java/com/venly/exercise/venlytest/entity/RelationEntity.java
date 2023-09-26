package com.venly.exercise.venlytest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "RELATIONS")
@Getter
@Setter
@EqualsAndHashCode
public class RelationEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO, generator="relation_seq_gen")
  @SequenceGenerator(name="relation_seq_gen", sequenceName="RELATION_SEQ", allocationSize=1)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "word1", nullable = false)
  private String word1;

  @Column(name = "word2", nullable = false)
  private String word2;

  @Column(name = "relation", nullable = false)
  private String relation;

}
