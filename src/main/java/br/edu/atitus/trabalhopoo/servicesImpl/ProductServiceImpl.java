package br.edu.atitus.trabalhopoo.servicesImpl;

import br.edu.atitus.trabalhopoo.models.ProductModel;
import br.edu.atitus.trabalhopoo.repositories.GenericRepository;
import br.edu.atitus.trabalhopoo.repositories.ProductRepository;
import br.edu.atitus.trabalhopoo.services.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
  final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    super();
    this.productRepository = productRepository;
  }

  @Override
  public void validarSave(ProductModel objeto) throws Exception {
    ProductService.super.validarSave(objeto);
  }

  @Override
  public GenericRepository<ProductModel> getRepository() {
    return productRepository;
  }
}
