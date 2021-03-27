package org.activemqexamples;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.activemqexamples.jms.JMSMessageReceiver;
import org.activemqexamples.jms.JMSMessageSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMQExampleTest {

  @Autowired
  private JMSMessageSender sender;

  @Autowired
  private JMSMessageReceiver receiver;

  @Test
  public void testReceive() throws Exception {
    sender.send("Sending Message - Example Test");

    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
  }
}
