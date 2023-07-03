package br.edu.atitus.trabalhopoo.services;

import br.edu.atitus.trabalhopoo.models.GenericModel;
import br.edu.atitus.trabalhopoo.repositories.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericService<TEntidade extends GenericModel> {

  GenericRepository<TEntidade> getRepository();

  default void validarSave(TEntidade objeto) throws Exception {
  }

  default TEntidade save(TEntidade objeto) throws Exception {
    validarSave(objeto);
    return getRepository().save(objeto);
  }

  default Optional<TEntidade> findById(long id) throws Exception{
    if (!getRepository().existsById(id))
      throw new Exception("Não existe registro com este Id");
    return getRepository().findById(id);
  }

  default void deleteById(long id) {
    getRepository().deleteById(id);;
  }

  default Page<TEntidade> findByNome(Pageable pageable, String name){
    return getRepository().findByNomeContainingIgnoreCase(pageable, name);
  }
}