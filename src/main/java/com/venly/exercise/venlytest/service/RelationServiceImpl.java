package com.venly.exercise.venlytest.service;

import com.venly.exercise.venlytest.domain.Relation;
import com.venly.exercise.venlytest.entity.RelationEntity;
import com.venly.exercise.venlytest.repository.RelationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RelationServiceImpl implements RelationService {
  private final RelationRepository relationRepository;

  public RelationServiceImpl(RelationRepository relationRepository) {
    this.relationRepository = relationRepository;
  }

  @Override
  @Transactional
  public void addRelation(Relation relation) {
    relationRepository.save(convertToEntity(relation));
  }

//  public Relation getAllRelations() {
//
//  }

  private RelationEntity convertToEntity(Relation relation) {
    RelationEntity entity = new RelationEntity();
    entity.setWord1(relation.getWord1());
    entity.setWord2(relation.getWord2());
    entity.setRelation(relation.getRelation());
    return entity;
  }

}
