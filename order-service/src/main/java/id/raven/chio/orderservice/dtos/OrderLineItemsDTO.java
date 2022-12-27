package id.raven.chio.orderservice.dtos;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsDTO {

  private String skuCode;

  private BigDecimal price;

  private Integer quantity;

}
