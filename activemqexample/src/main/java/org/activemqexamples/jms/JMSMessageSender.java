package org.activemqexamples.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class JMSMessageSender {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(JMSMessageSender.class);

  @Autowired
  private JmsTemplate jmsTemplate;

  public void send(String message) {
    LOGGER.info("sending the message to receiver '{}'", message);
    jmsTemplate.convertAndSend("activemq.example", message);
  }
}
