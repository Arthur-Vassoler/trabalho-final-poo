package br.edu.atitus.trabalhopoo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class OrderModel extends GenericModel {
  public OrderModel() {
    this.data = LocalDateTime.now();
  }

  @Column
  private LocalDateTime data;

  @OneToOne
  @JoinColumn(name = "produto_id")
  private ProductModel produto;

  @Column
  private Double quantity;
}
