package id.raven.chio.productservice.dtos.request;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

  private String name;

  private String description;

  private BigDecimal price;

  private String email;

  private String password;

}
