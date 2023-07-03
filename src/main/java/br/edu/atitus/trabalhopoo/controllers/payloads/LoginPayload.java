package br.edu.atitus.trabalhopoo.controllers.payloads;

import lombok.Data;

@Data
public class LoginPayload {
  private String email;
  private String password;
}
