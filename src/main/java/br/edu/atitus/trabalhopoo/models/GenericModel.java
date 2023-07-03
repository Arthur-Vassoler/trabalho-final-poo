package br.edu.atitus.trabalhopoo.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@MappedSuperclass
@Data
public class GenericModel extends RepresentationModel<GenericModel> implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String nome;
}
