package id.raven.chio.notificationservice.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationEvent {

  @KafkaListener(topics = "notificationTopic")
  public void handleNotification(Object orderPlacedEvent) {
    // send out and email notification
    log.info("Received Notification for order - {}", orderPlacedEvent);
  }

}
