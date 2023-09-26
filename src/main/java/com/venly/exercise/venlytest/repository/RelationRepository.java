package com.venly.exercise.venlytest.repository;

import com.venly.exercise.venlytest.entity.RelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationRepository extends JpaRepository<RelationEntity, Long> {

}
