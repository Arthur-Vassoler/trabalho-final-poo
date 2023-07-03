package br.edu.atitus.trabalhopoo.repositories;

import br.edu.atitus.trabalhopoo.models.UserModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<UserModel> {
  Optional<UserModel> findByEmail(String email);
}
