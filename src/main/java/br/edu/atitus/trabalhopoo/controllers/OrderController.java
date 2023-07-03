package br.edu.atitus.trabalhopoo.controllers;

import br.edu.atitus.trabalhopoo.models.OrderModel;
import br.edu.atitus.trabalhopoo.services.GenericService;
import br.edu.atitus.trabalhopoo.services.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class OrderController extends GenericController<OrderModel> {
  final OrderService orderService;

  public OrderController(OrderService orderService) {
    super();
    this.orderService = orderService;
  }

  @Override
  GenericService<OrderModel> getService() {
    return orderService;
  }
}
