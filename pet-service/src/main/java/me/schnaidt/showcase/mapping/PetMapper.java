package me.schnaidt.showcase.mapping;

import me.schnaidt.showcase.api.model.Pet;
import me.schnaidt.showcase.persistence.model.PetEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PetMapper {
  Pet map(PetEntity example);

  PetEntity map(Pet example);
}
