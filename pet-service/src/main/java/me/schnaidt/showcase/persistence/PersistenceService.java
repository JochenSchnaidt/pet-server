package me.schnaidt.showcase.persistence;

import lombok.extern.slf4j.Slf4j;
import me.schnaidt.showcase.persistence.model.PetEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class PersistenceService {

  List<PetEntity> petList = new ArrayList<>();

  public List<PetEntity> listPets() {
    return petList;
  }

  public Optional<PetEntity> showPetById(String petId) {
    long id = Long.parseLong(petId);
    return petList.stream().filter(p -> p.getId().equals(id)).findAny();
  }

  @PostConstruct
  public void init() {
    PetEntity pet1 = new PetEntity();
    pet1.setId(1L);
    pet1.setName("Bello");
    pet1.setTag("Hund");
    petList.add(pet1);

    PetEntity pet2 = new PetEntity();
    pet2.setId(2L);
    pet2.setName("Mieze");
    pet2.setTag("Katze");
    petList.add(pet2);

    PetEntity pet3 = new PetEntity();
    pet3.setId(3L);
    pet3.setName("Günther");
    pet3.setTag("Hamster");
    petList.add(pet3);

    PetEntity pet4 = new PetEntity();
    pet4.setId(4L);
    pet4.setName("Goldi");
    pet4.setTag("Hamster");
    petList.add(pet4);

    PetEntity pet5 = new PetEntity();
    pet5.setId(5L);
    pet5.setName("Günther");
    pet5.setTag("Esel");
    petList.add(pet5);

    log.info("pets initialized");
  }
}
