package id.raven.chio.productservice.mapper;

import id.raven.chio.productservice.models.Product;
import id.raven.chio.productservice.dtos.response.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public static ProductResponse toResponse(Product product) {
    return ProductResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .build();
  }

}
