package me.schnaidt.showcase.controller;

import lombok.extern.slf4j.Slf4j;
import me.schnaidt.showcase.api.PetsApi;
import me.schnaidt.showcase.api.model.Error;
import me.schnaidt.showcase.api.model.Pet;
import me.schnaidt.showcase.business.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class PetsController implements PetsApi {

  @Autowired
  private PetService petService;

  @Override
  public ResponseEntity<Void> createPets() {
    log.info("createPets called");
    petService.createPets();
    return ResponseEntity.accepted().build();
  }

  @Override
  public ResponseEntity<List<Pet>> listPets(@Valid Integer limit) {
    log.info("listPets called");
    return ResponseEntity.ok(petService.listPets(limit));
  }

  @Override
  public ResponseEntity<Pet> showPetById(String petId) {
    log.info("showPetById called with {}", petId);

    Optional<Pet> value = petService.showPetById(petId);

    if (!value.isPresent()) {
      log.info("Kein Tier mit ID '{}' gefunden", petId);
      Error e = new Error();
      e.setCode(404);
      e.setMessage("Kein Tier mit ID '" + petId + "' gefunden");
      ResponseEntity errorResult = ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body(e.toString());
      return errorResult;
    }

    return ResponseEntity.ok(value.get());
  }
}
