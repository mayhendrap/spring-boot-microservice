package id.raven.chio.orderservice.services;

import id.raven.chio.orderservice.dtos.request.OrderRequest;
import id.raven.chio.orderservice.dtos.response.InventoryResponse;
import id.raven.chio.orderservice.events.OrderPlacedEvent;
import id.raven.chio.orderservice.mappers.OrderMapper;
import id.raven.chio.orderservice.models.Order;
import id.raven.chio.orderservice.models.OrderLineItems;
import id.raven.chio.orderservice.repositories.OrderRepository;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final WebClient.Builder webClientBuilder;
  private final KafkaTemplate<String, Object> kafkaTemplate;

  public String placeOrder(OrderRequest request) {
    List<OrderLineItems> orderLineItems = request.getOrderLineItemsList()
        .stream()
        .map(OrderMapper::toDTO)
        .toList();

    Order order = new Order();
    order.setOrderNumber(UUID.randomUUID().toString());
    order.setOrderLineItemsList(orderLineItems);

    List<String> skuCodes = order.getOrderLineItemsList()
        .stream()
        .map(OrderLineItems::getSkuCode)
        .toList();

    InventoryResponse[] inventoryResponsesArray = webClientBuilder.build()
        .get()
        .uri("http://inventory-service/inventories",
            uriBuilder ->
                uriBuilder
                    .queryParam("skuCodes", skuCodes)
                    .build()
        )
        .retrieve()
        .bodyToMono(InventoryResponse[].class)
        .block();

    boolean allProductsInStock = Arrays.stream(inventoryResponsesArray)
        .allMatch(InventoryResponse::isInStock);

    if (allProductsInStock) {
      orderRepository.save(order);
      kafkaTemplate.send("notificationTopic", order.getId().toString(), new OrderPlacedEvent(order.getOrderNumber()));
      return "Order placed successfully";
    } else {
      throw new IllegalArgumentException("Product is not in stock, please try again later");
    }

  }

}
