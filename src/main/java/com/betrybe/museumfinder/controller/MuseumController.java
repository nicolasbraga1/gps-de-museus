package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe MuseumController.
 */
@RestController
@RequestMapping("/museum")
public class MuseumController {

  private final MuseumServiceInterface museumServiceInterface;

  @Autowired
  public MuseumController(MuseumServiceInterface museumServiceInterface) {
    this.museumServiceInterface = museumServiceInterface;
  }

  @PatchMapping
  public ResponseEntity<Museum> newMuseum(@RequestBody Museum newMuseum) {
    this.museumServiceInterface.createMuseum(newMuseum);
    return ResponseEntity.status(HttpStatus.CREATED).body(newMuseum);
  }
}
