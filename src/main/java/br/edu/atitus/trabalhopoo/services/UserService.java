package br.edu.atitus.trabalhopoo.services;

import br.edu.atitus.trabalhopoo.models.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends GenericService<UserModel>, UserDetailsService {
}
