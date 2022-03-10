package ru.vlapin.trainings.integrationtraining.service.jsonplaceholder;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.vlapin.trainings.integrationtraining.model.jsonplaceholder.Address;
import ru.vlapin.trainings.integrationtraining.model.jsonplaceholder.Geo;
import ru.vlapin.trainings.integrationtraining.model.jsonplaceholder.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class UserServiceTests {

  UserService userService;

  @Test
  @SneakyThrows
  @DisplayName("Users endpoint for all works correctly")
  void usersEndpointForAllWorksCorrectlyTest() {
    assertThat(userService.all()).isNotNull()
        .hasSize(10);
  }

  @Test
  @SneakyThrows
  @DisplayName("Users endpoint for one user by id works correctly")
  void usersEndpointForOneUserByIdWorksCorrectlyTest() {
    assertThat(userService.findById(1L)).isNotNull()
        .extracting(User::getAddress)
        .extracting(Address::getGeo)
        .extracting(Geo::getLatitude, Geo::getLongitude)
        .contains(-37.3159, 81.1496);
  }
}
