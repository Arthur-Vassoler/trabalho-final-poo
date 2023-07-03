package br.edu.atitus.trabalhopoo.servicesImpl;

import br.edu.atitus.trabalhopoo.models.OrderModel;
import br.edu.atitus.trabalhopoo.repositories.GenericRepository;
import br.edu.atitus.trabalhopoo.repositories.OrderRepository;
import br.edu.atitus.trabalhopoo.repositories.ProductRepository;
import br.edu.atitus.trabalhopoo.services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
  final OrderRepository orderRepository;
  final ProductRepository productRepository;

  public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
    super();
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
  }

  @Override
  public GenericRepository<OrderModel> getRepository() {
    return orderRepository;
  }

  @Override
  public void validarSave(OrderModel objeto) throws Exception {
    OrderService.super.validarSave(objeto);
  }
}
