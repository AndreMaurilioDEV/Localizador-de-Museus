package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ServiceTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MuseumFakeDatabase museumFakeDatabase;

  @Test
  void testMuseumNotFound() throws Exception {
    Mockito
            .when(museumFakeDatabase.getMuseum(0L))
            .thenThrow(new MuseumNotFoundException());

    ResultActions result = mockMvc.perform(
            get("/museums/0"));

    result.andExpect(status().isNotFound());

   /// Mockito.verify((museumFakeDatabase).getMuseum(0L));

  }

  @Test
  void testInvalidCoordinate() throws Exception {
    Coordinate coordinate = new Coordinate(91, 181);
    Mockito
            .when(museumFakeDatabase.getClosestMuseum(coordinate, 10.0))
            .thenThrow(new InvalidCoordinateException());

    ResultActions result = mockMvc.perform(
            get("/museums/closest?lat=91.0&lng=181.0&max_dist_km=10"));

    result.andExpect(status().isBadRequest());

    /// Mockito.verify((museumFakeDatabase).getMuseum(0L));

  }

  @Test
  void testValidMuseum() throws Exception {
    Museum museum = new Museum();
    museum.setId(1L);
    museum.setName("Museu Casa Memória dos Ex-Combatentes da Segunda Guerra Mundial");
    museum.setDescription("Preservação da memória dos ex-combatentes da Segunda Guerra.");
    museum.setAddress("SGAN 913, s/n, conjunto F , Asa Norte, 70790-130, Brasília, DF");
    museum.setCollectionType("História");
    museum.setSubject("História");
    museum.setUrl("");
    museum.setCoordinate(new Coordinate(-15.75063, -47.9001824));
    Mockito
            .when(museumFakeDatabase.getMuseum(1L))
            .thenReturn(Optional.of(museum));

    ResultActions result = mockMvc.perform(
            get("/museums/1"));

    result.andExpect(status().isOk());
    //Mockito.verify((museumFakeDatabase).getMuseum(1L));
  }
}
