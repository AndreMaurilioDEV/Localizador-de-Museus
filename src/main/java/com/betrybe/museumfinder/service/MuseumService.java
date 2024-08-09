package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * The type Museum service.
 */
@Service
public class MuseumService implements MuseumServiceInterface {

  private MuseumFakeDatabase museumFakeDatabase;

  /**
   * Instantiates a new Museum service.
   *
   * @param museumFakeDatabase the museum fake database
   */
  public MuseumService(MuseumFakeDatabase museumFakeDatabase) {
    this.museumFakeDatabase = museumFakeDatabase;
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    if (CoordinateUtil.isCoordinateValid(coordinate)) {
      return museumFakeDatabase.getClosestMuseum(coordinate, maxDistance)
             .orElseThrow(MuseumNotFoundException::new);
    } else {
      throw new InvalidCoordinateException();
    }
  }

  @Override
  public Museum createMuseum(Museum museum)  {
    if (CoordinateUtil.isCoordinateValid(museum.getCoordinate())) {
      return museumFakeDatabase.saveMuseum(museum);
    } else {
      throw new InvalidCoordinateException();
    }

  }

  @Override
  public Museum getMuseum(Long id) {
    return museumFakeDatabase.getMuseum(id).orElseThrow(MuseumNotFoundException::new);
  }
}
