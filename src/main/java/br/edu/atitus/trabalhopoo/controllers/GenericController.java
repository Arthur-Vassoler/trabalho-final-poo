package br.edu.atitus.trabalhopoo.controllers;

import br.edu.atitus.trabalhopoo.models.GenericModel;
import br.edu.atitus.trabalhopoo.services.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Optional;
import java.util.UUID;

public abstract class GenericController<TEntidade extends GenericModel> {
  abstract GenericService<TEntidade> getService();

  private ResponseEntity<Object> salvar(TEntidade entidade) {
    try {
      getService().save(entidade);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    return ResponseEntity.status(HttpStatus.OK).body(entidade);
  }

  @PostMapping
  public ResponseEntity<Object> postUsuario(@RequestBody TEntidade entidade) {
    return salvar(entidade);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> putUsuario(@PathVariable UUID id, @RequestBody TEntidade entidade) {
    entidade.setId(id);

    return salvar(entidade);
  }

  @GetMapping()
  public ResponseEntity<Object> getEntidades(
    @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
    @RequestParam String name) throws Exception {
    Page<TEntidade> entidades = getService().findByName(pageable, name);

    for (TEntidade tEntidade : entidades) {
      UUID id = tEntidade.getId();

      tEntidade.add(linkTo(methodOn(GenericController.class).getEntidadesById(id)).withSelfRel());
      tEntidade.add(linkTo(methodOn(GenericController.class).putUsuario(id, tEntidade))
        .withRel("PUT - Alterar"));
      tEntidade.add(linkTo (methodOn(GenericController.class).deleteUsuario(id)).withRel("DELETE - Remover"));
    }
    return ResponseEntity.status(HttpStatus.OK).body(entidades);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getEntidadesById(@PathVariable UUID id) throws Exception {
    Optional<TEntidade> entidade = getService().findById(id);
    if (entidade.isEmpty())
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TEntidade não encontrado com o Id " + id);
    else {

      entidade.get().add(linkTo(methodOn(GenericController.class).getEntidadesById(id)).withSelfRel());
      entidade.get().add(linkTo(methodOn(GenericController.class).putUsuario(id, entidade.get())).withRel("PUT - Alterar"));
      entidade.get().add(linkTo(methodOn(GenericController.class).deleteUsuario(id)).withRel("DELETE - Remover"));

      // Adiciona o link para retornar à lista de usuários
      entidade.get().add(linkTo(GenericController.class).withRel("Lista de Registros"));

      return ResponseEntity.status(HttpStatus.OK).body(entidade);
    }
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteUsuario(@PathVariable UUID id) {
    getService().deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body("Usuário com Id " + id + " deletado com sucesso!");
  }

}