package com.venly.exercise.venlytest.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.venly.exercise.venlytest.domain.Relation;
import com.venly.exercise.venlytest.repository.RelationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RelationServiceImplTest {
  private RelationService relationService;
  @Mock
  private RelationRepository relationRepository;

  @Before
  public void setup() {
    relationService = new RelationServiceImpl(relationRepository);
  }

  @Test
  public void addRelation() {
    Relation relation = new Relation();
    relation.setWord1("speech");
    relation.setWord2("talk");
    relation.setRelation("synonym");

    when(relationRepository.save(any())).thenReturn(any());

    relationService.addRelation(relation);

    verify(relationRepository).save(any());
  }

}