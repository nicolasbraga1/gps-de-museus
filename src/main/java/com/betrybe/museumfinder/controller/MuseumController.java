package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe MuseumController.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {

  private final MuseumServiceInterface museumServiceInterface;

  @Autowired
  public MuseumController(MuseumServiceInterface museumServiceInterface) {
    this.museumServiceInterface = museumServiceInterface;
  }

  /**
   * Rota post new museum.
   */
  @PostMapping
  public ResponseEntity<Museum> newMuseum(@RequestBody Museum newMuseum) {
    this.museumServiceInterface.createMuseum(newMuseum);
    return ResponseEntity.status(HttpStatus.CREATED).body(newMuseum);
  }

  /**
   * Rota get closest.
   */
  @GetMapping("/closest")
  public ResponseEntity<Museum> getClosestMuseum(
      @RequestParam Double lat, Double lng, @RequestParam("max_dist_km") Double maxDistance) {
    Museum museum = this.museumServiceInterface
        .getClosestMuseum(new Coordinate(lat, lng), maxDistance);
    return ResponseEntity.ok(museum);
  }
}
