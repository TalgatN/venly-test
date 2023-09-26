package com.venly.exercise.venlytest.service;

import com.venly.exercise.venlytest.domain.Relation;
import com.venly.exercise.venlytest.entity.RelationEntity;
import com.venly.exercise.venlytest.repository.RelationRepository;
import java.util.Set;
import java.util.stream.Collectors;
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

  @Override
  public Set<Relation> getAllRelations() {
    return relationRepository.findAll()
        .stream()
        .map(this::entityToDomain)
        .collect(Collectors.toSet());
  }

  private Relation entityToDomain(RelationEntity relationEntity) {
    Relation relation = new Relation();
    relation.setId(relationEntity.getId());
    relation.setWord1(relationEntity.getWord1());
    relation.setWord2(relationEntity.getWord2());
    relation.setRelation(relationEntity.getRelation());
    return relation;
  }

  private RelationEntity convertToEntity(Relation relation) {
    RelationEntity entity = new RelationEntity();
    entity.setWord1(relation.getWord1());
    entity.setWord2(relation.getWord2());
    entity.setRelation(relation.getRelation());
    return entity;
  }

}
