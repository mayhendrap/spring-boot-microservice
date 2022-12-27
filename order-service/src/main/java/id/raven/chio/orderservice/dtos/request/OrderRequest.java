package id.raven.chio.orderservice.dtos.request;

import id.raven.chio.orderservice.dtos.OrderLineItemsDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

  private List<OrderLineItemsDTO> orderLineItemsList;

}
