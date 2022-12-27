package id.raven.chio.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductServiceApp {

  public static void main(String[] args) {
    SpringApplication.run(ProductServiceApp.class, args);
  }

}
