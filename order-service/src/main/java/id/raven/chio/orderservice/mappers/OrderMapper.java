package id.raven.chio.orderservice.mappers;

import id.raven.chio.orderservice.models.OrderLineItems;
import id.raven.chio.orderservice.dtos.OrderLineItemsDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

  public static OrderLineItems toDTO(OrderLineItemsDTO dto) {
    return OrderLineItems.builder()
        .skuCode(dto.getSkuCode())
        .price(dto.getPrice())
        .quantity(dto.getQuantity())
        .build();
  }

}
