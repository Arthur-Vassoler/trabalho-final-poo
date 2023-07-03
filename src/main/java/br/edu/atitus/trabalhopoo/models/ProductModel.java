package br.edu.atitus.trabalhopoo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class ProductModel extends GenericModel {
  @NotBlank(message = "Campo description não pode ser vazio.")
  @Column
  private String description;

  @NotBlank(message = "Campo unitMeasure não pode ser vazio.")
  @Column
  private String unitMeasure;

  @Column(name = "unit_value", nullable = false)
  private Double unitValue;
}
