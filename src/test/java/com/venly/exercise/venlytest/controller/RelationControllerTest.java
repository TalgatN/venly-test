package com.venly.exercise.venlytest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.venly.exercise.venlytest.domain.Relation;
import com.venly.exercise.venlytest.service.RelationService;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RelationControllerTest {
  @InjectMocks
  private RelationController controller;
  @Mock
  private RelationService relationService;
  @Autowired
  private MockMvc mockMvc;

  private ObjectMapper objectMapper;

  @Before
  public void setup() {
    objectMapper = new ObjectMapper();
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void testCreateRelation() throws Exception {
    Relation relation = getRelation();

    mockMvc.perform(post("/relation/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(relation)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("Created"));
  }

//  @Test
//  public void testGetAllRelations() throws Exception {
//    Relation relation = getRelation();
//
//    when(relationService.getAllRelations()).thenReturn(Set.of(relation));
//
//    mockMvc.perform(get("/relation/all"))
//        .andDo(print())
//        .andExpect(status().isOk())
//        .andExpect(content().string(objectMapper.writeValueAsString(Set.of(relation))));
//  }

  private static Relation getRelation() {
    Relation relation = new Relation();
    relation.setId(1L);
    relation.setWord1("speech");
    relation.setWord2("talk");
    relation.setRelation("synonym");
    return relation;
  }

}