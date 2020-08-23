package me.schnaidt.showcase.business;

import lombok.extern.slf4j.Slf4j;
import me.schnaidt.showcase.api.model.Pet;
import me.schnaidt.showcase.mapping.PetMapper;
import me.schnaidt.showcase.persistence.PersistenceService;
import me.schnaidt.showcase.persistence.model.PetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PetServiceImpl implements PetService {

  @Autowired
  private PersistenceService persistenceService;

  @Autowired
  private PetMapper mapper;

  @Override
  public void createPets() {
    log.info("pets already created");
  }

  @Override
  public List<Pet> listPets(Integer limit) {

    List<PetEntity> petEntities = persistenceService.listPets();
    log.info("persistence returned {} pets", petEntities.size());

    List<Pet> petList = petEntities.stream().map(entity -> mapper.map(entity)).collect(Collectors.toList());
    log.info("mapped to {} pets", petList.size());
    return petList;
  }

  @Override
  public Optional<Pet> showPetById(String petId) {
    Optional<PetEntity> petEntity = persistenceService.showPetById(petId);
    return petEntity.map(e -> mapper.map(e));
  }
}
