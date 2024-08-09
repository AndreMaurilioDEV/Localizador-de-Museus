package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Museum controller.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  private MuseumServiceInterface museumServiceInterface;

  /**
   * Instantiates a new Museum controller.
   *
   * @param museumServiceInterface the museum service interface
   */
  public MuseumController(MuseumServiceInterface museumServiceInterface) {
    this.museumServiceInterface = museumServiceInterface;
  }

  /**
   * Post museum response entity.
   *
   * @param newMuseum the new museum
   * @return the response entity
   */
  @PostMapping("/museum")
  public ResponseEntity<MuseumCreationDto> postMuseum(@RequestBody MuseumCreationDto newMuseum) {
    Museum museum = new Museum();
    museum.setAddress(newMuseum.address());
    museum.setCoordinate(newMuseum.coordinate());
    museum.setDescription(newMuseum.description());
    museum.setName(newMuseum.name());
    museum.setUrl(newMuseum.url());
    museum.setCoordinate(newMuseum.coordinate());
    museum.setCollectionType(newMuseum.collectionType());
    museum.setSubject(newMuseum.subject());
    Museum museumCreate = museumServiceInterface.createMuseum(museum);
    MuseumCreationDto museumCreationDto = new MuseumCreationDto(
            museumCreate.getName(),
            museumCreate.getDescription(),
            museumCreate.getAddress(),
            museumCreate.getCollectionType(),
            museumCreate.getSubject(),
            museumCreate.getUrl(),
            museumCreate.getCoordinate()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(museumCreationDto);
  }


  /**
   * Gets museums.
   *
   * @param latitude      the latitude
   * @param longitude     the longitude
   * @param maxDistanceKm the max distance km
   * @return the museums
   */
  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getMuseums(@RequestParam(name = "lat") Double latitude,
                                              @RequestParam(name = "lng") Double longitude,
                                              @RequestParam(name = "max_dist_km")
                                                Double maxDistanceKm) {
    Museum musemClosest = museumServiceInterface
            .getClosestMuseum(new Coordinate(latitude, longitude),
                    maxDistanceKm);
    MuseumDto museumDto = new MuseumDto(
            musemClosest.getId(),
            musemClosest.getName(),
            musemClosest.getDescription(),
            musemClosest.getAddress(),
            musemClosest.getCollectionType(),
            musemClosest.getSubject(),
            musemClosest.getUrl(),
            musemClosest.getCoordinate()
    );
    return ResponseEntity.ok(museumDto);
  }

  /**
   * Gets museum per id.
   *
   * @param id the id
   * @return the museum per id
   */
  @GetMapping("/{id}")
  public ResponseEntity<MuseumDto> getMuseumPerId(@PathVariable Long id) {
    Museum museum = museumServiceInterface.getMuseum(id);
    MuseumDto museumDto = new MuseumDto(
            museum.getId(),
            museum.getName(),
            museum.getDescription(),
            museum.getAddress(),
            museum.getCollectionType(),
            museum.getSubject(),
            museum.getUrl(),
            museum.getCoordinate()
    );
    return ResponseEntity.ok(museumDto);
  }
}
