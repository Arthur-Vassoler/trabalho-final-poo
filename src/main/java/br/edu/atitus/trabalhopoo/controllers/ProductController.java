package br.edu.atitus.trabalhopoo.controllers;

import br.edu.atitus.trabalhopoo.models.ProductModel;
import br.edu.atitus.trabalhopoo.services.GenericService;
import br.edu.atitus.trabalhopoo.services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProductController extends GenericController<ProductModel> {
  final ProductService productService;

  public ProductController(ProductService productService) {
    super();
    this.productService = productService;
  }

  @Override
  GenericService<ProductModel> getService() {
    return productService;
  }
}
