package id.raven.chio.inventoryservice.services;

import id.raven.chio.inventoryservice.models.Inventory;
import id.raven.chio.inventoryservice.repositories.InventoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryService {

  private final InventoryRepository inventoryRepository;

  @SneakyThrows
  @Transactional(readOnly = true)
  public List<Inventory> isInStock(List<String> skuCodes) {
    return inventoryRepository.findBySkuCodeIn(skuCodes);
  }

}
