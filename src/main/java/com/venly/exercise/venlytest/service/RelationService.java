package com.venly.exercise.venlytest.service;

import com.venly.exercise.venlytest.domain.Relation;
import java.util.Set;

public interface RelationService {
  void addRelation(Relation relation);

  Set<Relation> getAllRelations();

}
