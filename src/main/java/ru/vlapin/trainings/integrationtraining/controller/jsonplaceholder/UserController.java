package ru.vlapin.trainings.integrationtraining.controller.jsonplaceholder;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.vlapin.trainings.integrationtraining.model.jsonplaceholder.User;
import ru.vlapin.trainings.integrationtraining.service.jsonplaceholder.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

  UserService userService;

  @NotNull
  @GetMapping
  public List<User> all() {
    return userService.all();
  }

  @GetMapping("{id}")
  public User byId(@PathVariable @NotNull Long id) {
    return userService.findById(id);
  }
}
