package com.venly.exercise.venlytest.controller;

import com.venly.exercise.venlytest.domain.Relation;
import com.venly.exercise.venlytest.service.RelationService;
import jakarta.validation.Valid;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relation")
public class RelationController {
  private final RelationService relationService;

  public RelationController(RelationService relationService) {
    this.relationService = relationService;
  }

  @PostMapping("/create")
  public ResponseEntity<String> createRelation(@Valid @RequestBody Relation relation, BindingResult result) {
    if (result.hasErrors()) {
      return ResponseEntity.badRequest().body("has errors");
    }
    relationService.addRelation(relation);

    return ResponseEntity.ok("Created");
  }

  @GetMapping("/all")
  public ResponseEntity<Set<Relation>> getAllRelations() {
    return ResponseEntity.ok( relationService.getAllRelations());
  }

}
