package br.edu.atitus.trabalhopoo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
@Data
public class OrderModel extends GenericModel {
  @Column
  private LocalDateTime data;

  @ManyToOne
  @JoinColumn(name = "produto_id")
  private ProductModel produto;

  @Column
  private Double quantidade;
}
