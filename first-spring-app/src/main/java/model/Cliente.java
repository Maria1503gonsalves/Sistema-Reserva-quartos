package model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.util.List;

@Entity
@Table
@Log
@Setter
@Getter
public class Cliente {
    @Id
    @GeneratedValue
 private Long idCliente;
 private String nome;
 private String telefone;
 private int cpf;


    public Cliente(Long idCliente,String nome,String telefone,int cpf) {
        this.idCliente=idCliente;
        this.nome=nome;
        this.telefone=telefone;
        this.cpf=cpf;



    }
}





