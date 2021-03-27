package org.activemqexamples.jms;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

public class JMSMessageReceiver {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(JMSMessageReceiver.class);

  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }

  @JmsListener(destination = "activemq.example")
  public void receive(String message) {
    LOGGER.info("received the message from sender '{}'", message);
    latch.countDown();
  }
}
