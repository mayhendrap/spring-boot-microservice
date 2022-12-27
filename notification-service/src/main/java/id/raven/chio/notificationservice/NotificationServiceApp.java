package id.raven.chio.notificationservice;

import id.raven.chio.notificationservice.events.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@SpringBootApplication
public class NotificationServiceApp {

  public static void main(String[] args) {
    SpringApplication.run(NotificationServiceApp.class, args);
  }

}
