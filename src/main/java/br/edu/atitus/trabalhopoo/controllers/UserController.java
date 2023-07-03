package br.edu.atitus.trabalhopoo.controllers;

import br.edu.atitus.trabalhopoo.models.UserModel;
import br.edu.atitus.trabalhopoo.services.GenericService;
import br.edu.atitus.trabalhopoo.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends GenericController<UserModel> {
  final UserService userService;

  public UserController(UserService userService) {
    super();
    this.userService = userService;
  }

  @Override
  GenericService<UserModel> getService() {
    return userService;
  }
}
