package br.edu.atitus.trabalhopoo.repositories;

import br.edu.atitus.trabalhopoo.models.GenericModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface GenericRepository<TEntidade extends GenericModel>
  extends JpaRepository<TEntidade, UUID> {
  Page<TEntidade> findByNameContainingIgnoreCase(Pageable pageable, String name);
}