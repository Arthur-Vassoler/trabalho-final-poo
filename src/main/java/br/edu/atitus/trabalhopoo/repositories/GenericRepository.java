package br.edu.atitus.trabalhopoo.repositories;

import br.edu.atitus.trabalhopoo.models.GenericModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface GenericRepository<TEntidade extends GenericModel>
  extends JpaRepository<TEntidade, Long> {
  Page<TEntidade> findByNomeContainingIgnoreCase(Pageable pageable, String name);
}