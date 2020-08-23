package me.schnaidt.showcase.business;

import me.schnaidt.showcase.api.model.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {

  void createPets();

  List<Pet> listPets(Integer limit);

  Optional<Pet> showPetById(String petId);

}
