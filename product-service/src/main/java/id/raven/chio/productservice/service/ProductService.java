package id.raven.chio.productservice.service;

import id.raven.chio.productservice.dtos.request.ProductRequest;
import id.raven.chio.productservice.models.Product;
import id.raven.chio.productservice.repositories.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public void createProduct(ProductRequest request) {
    Product product = Product.builder()
        .name(request.getName())
        .description(request.getDescription())
        .price(request.getPrice())
        .build();

    productRepository.save(product);
    log.info("Product with id [{}] was saved", product.getId());
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }
}
