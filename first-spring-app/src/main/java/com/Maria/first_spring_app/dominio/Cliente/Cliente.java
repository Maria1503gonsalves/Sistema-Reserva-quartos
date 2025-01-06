package com.Maria.first_spring_app.dominio.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.rmi.server.UID;
import java.util.UUID;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue
  private UUID idcliente;
  private String email;
  private String  Telefone;
  private String cpf;
  private String nome;

    private UUID getId() {
        return idcliente;
    }

    private void setId(UUID id) {
        this.idcliente = idcliente;
    }

    private String getTelefone() {
        return Telefone;
    }

    private void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    private String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }

    private String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

}
