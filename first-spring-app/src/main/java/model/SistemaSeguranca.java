package model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import model.Cliente;

@Entity
@Table
@Log
@Getter
@Setter
public class SistemaSeguranca {
    private String frequencia;
    private Data ultimoBackup;


    public SistemaSeguranca(String frequencia,Data ultimoBackup) {
        this.frequencia = frequencia;
        this.ultimoBackup=ultimoBackup;


    }
}
