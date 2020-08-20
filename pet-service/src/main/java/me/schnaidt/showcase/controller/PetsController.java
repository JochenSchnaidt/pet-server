package me.schnaidt.showcase.controller;

import lombok.extern.slf4j.Slf4j;
import me.schnaidt.showcase.api.PetsApi;
import me.schnaidt.showcase.api.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class PetsController implements PetsApi {

  @Override
  public ResponseEntity<Void> createPets() {
    return null;
  }

  @Override
  public ResponseEntity<List<Pet>> listPets(@Valid Integer limit) {
    return null;
  }

  @Override
  public ResponseEntity<Pet> showPetById(String petId) {
    return null;
  }
}
