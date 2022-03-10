package ru.vlapin.trainings.integrationtraining;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.vlapin.trainings.integrationtraining.common.wsdl.client.WsDemoService;

import static org.assertj.core.api.Assertions.*;

class WsDemoTests {

  @Test
  @SneakyThrows
  @DisplayName("WS business logic works correctly")
  void wSBusinessLogicWorksCorrectlyTest() {
    assertThat(new WsDemo().sayHello("Alex")).isNotNull()
        .isEqualTo("Hello, Alex!");
  }

  @Test
  @SneakyThrows
  @DisplayName("WebService works correctly")
  void webServiceWorksCorrectlyTest() {
    assertThat(new WsDemoService()
                   .getWsDemoPort()
                   .sayHello("Steve"))
        .isNotNull()
        .isEqualTo("Hello, Steve!");
  }
}
