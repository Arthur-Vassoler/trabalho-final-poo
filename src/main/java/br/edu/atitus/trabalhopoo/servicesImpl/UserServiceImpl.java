package br.edu.atitus.trabalhopoo.servicesImpl;

import br.edu.atitus.trabalhopoo.models.UserModel;
import br.edu.atitus.trabalhopoo.repositories.GenericRepository;
import br.edu.atitus.trabalhopoo.repositories.UserRepository;
import br.edu.atitus.trabalhopoo.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    super();
    this.userRepository = userRepository;
  }

  @Override
  public GenericRepository<UserModel> getRepository() {
    return userRepository;
  }

  @Override
  public void validarSave(UserModel objeto) throws Exception {
    UserService.super.validarSave(objeto);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return this.userRepository.findByEmail(email)
      .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email));
  }
}
