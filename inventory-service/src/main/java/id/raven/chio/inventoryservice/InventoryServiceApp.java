package id.raven.chio.inventoryservice;

import id.raven.chio.inventoryservice.models.Inventory;
import id.raven.chio.inventoryservice.repositories.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class InventoryServiceApp {

  public static void main(String[] args) {
    SpringApplication.run(InventoryServiceApp.class, args);
  }

  @Bean
  public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
    return args -> {
      Inventory inventory1 = new Inventory();
      inventory1.setSkuCode("gundam_gunpla_series_4");
      inventory1.setQuantity(100);

      Inventory inventory2 = new Inventory();
      inventory2.setSkuCode("gundam_gunpla_series_5");
      inventory2.setQuantity(0);

      inventoryRepository.save(inventory1);
      inventoryRepository.save(inventory2);
    };
  }

}
