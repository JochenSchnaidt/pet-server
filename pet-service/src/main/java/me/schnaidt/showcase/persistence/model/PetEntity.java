package me.schnaidt.showcase.persistence.model;

import lombok.Data;

@Data
public class PetEntity {

  private Long id;
  private String name;
  private String tag;
}
