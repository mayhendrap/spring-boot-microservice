package id.raven.chio.inventoryservice.controllers;

import id.raven.chio.inventoryservice.services.InventoryService;
import id.raven.chio.inventoryservice.dtos.InventoryResponse;
import id.raven.chio.inventoryservice.mappers.InventoryMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventories")
public class InventoryController {

  private final InventoryService inventoryService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<InventoryResponse> isInStock(@RequestParam List<String> skuCodes)
      throws InterruptedException {
    return inventoryService.isInStock(skuCodes)
        .stream()
        .map(InventoryMapper::toResponse)
        .toList();
  }

}
