package id.raven.chio.inventoryservice.mappers;

import id.raven.chio.inventoryservice.dtos.InventoryResponse;
import id.raven.chio.inventoryservice.models.Inventory;

public class InventoryMapper {

  public static InventoryResponse toResponse(Inventory inventory) {
    return InventoryResponse.builder()
        .skuCode(inventory.getSkuCode())
        .isInStock(inventory.getQuantity() > 0)
        .build();
  }

}
