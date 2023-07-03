package br.edu.atitus.trabalhopoo.controllers.payloads;

import lombok.Data;

@Data
public class SignupPayload {
  private String nome;
  private String email;
}
