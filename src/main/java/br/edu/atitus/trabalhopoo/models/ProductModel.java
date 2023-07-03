package br.edu.atitus.trabalhopoo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "produto")
@Data
public class ProductModel extends GenericModel {
  @NotBlank(message = "Campo descricao não pode ser vazio.")
  @Column
  private String descricao;

  @NotBlank(message = "Campo unidadeMedida não pode ser vazio.")
  @Column
  private String unidadeMedida;

  @Column(name = "unit_value", nullable = false)
  private Double valorUnitario;
}
