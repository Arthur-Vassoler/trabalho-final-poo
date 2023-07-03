package br.edu.atitus.trabalhopoo.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Data
public class GenericModel extends RepresentationModel<GenericModel> implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column
  private String name;
}
